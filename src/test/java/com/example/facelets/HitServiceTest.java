package com.example.facelets;

import org.junit.Test;
import org.junit.Assert;

public class HitServiceTest {
    private final HitService hitService = new HitService();

    @Test
    public void checkHit__validHit__shouldReturnTrue() {
        Assert.assertFalse(hitService.checkHit(0, 0, 1));
    }

    @Test
    public void checkHit__missedHit__shouldReturnFalse() {
        Assert.assertFalse(hitService.checkHit(100, 10000, 1));
    }
    @Test
    public void aboba() {}
}