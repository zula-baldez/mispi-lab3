package com.example.facelets;

public class HitService {
    public boolean checkHit(double x, double y, int r) {
        boolean hit;

        if (x >= 0 && y <= r / 2.0 - x && y >= 0) hit = true;
        else if (x >= 0 && y <= 0 && y >= -r && x <= r / 2.0) hit = true;
        else hit = x <= 0 && y >= 0 && x * x + y * y <= r * r;

        return hit;
    }
}
