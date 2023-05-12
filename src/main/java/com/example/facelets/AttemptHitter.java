package com.example.facelets;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

@ManagedBean
@SessionScoped
public class AttemptHitter {
    private double x;
    private double y;
    private int r;
    private int attempt = 0;
    private HitService hitService;

    public HitService getHitService() {
        return hitService;
    }

    @ManagedProperty(value = "#{dbManager}")
    private DbManager dbManager;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public DbManager getDbManager() {
        return dbManager;
    }

    public void setDbManager(DbManager dbManager) {
        this.dbManager = dbManager;
    }



    public void addHit() {
        if (r <= 0 || r > 5) {
            return;
        }
        attempt++;
        long start = System.currentTimeMillis();
        long start_time_nano = System.nanoTime();
        boolean hit = hitService.checkHit(x, y, r);
        Long startTime = (start);
        Long workTime = ((System.nanoTime() - start_time_nano));
        Attempt attempt = new Attempt(this.attempt, x, y, r, hit, workTime, startTime);
        dbManager.addAttempt(attempt);
    }

    public void addAttemptFromJsParams() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        try {
            if (r<=0 || r > 5) {
                return;
            }
            double x = Double.parseDouble(params.get("x"));
            double y = Double.parseDouble(params.get("y"));
            this.x = x;
            this.y = y;
            addHit();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }


}
