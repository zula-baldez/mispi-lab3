package com.example.facelets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HitServiceTest {
    private final HitService hitService = new HitService();

    @Test
    void checkHit__validHit__shouldReturnTrue() {
        Assertions.assertTrue(hitService.checkHit(0, 0, 1));
    }

    @Test
    void checkHit__missedHit__shouldReturnFalse() {
        Assertions.assertFalse(hitService.checkHit(100, 10000, 1));
    }
}