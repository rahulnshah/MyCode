package org.example.arrays;

import org.example.arrays.MovingAverage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingAverageTest {
    private static org.example.arrays.MovingAverage a;
    @BeforeAll
    public static void setupBeforeAll()
    {
        a = new MovingAverage(3);
    }
    @Test
    void next() {
        double ans = a.next(1);
        assertEquals(1.0, ans);
        ans = a.next(10);
        assertEquals(11.0/2, ans);
        ans = a.next(3);
        assertEquals(14.0/3, ans);
        ans = a.next(5);
        assertEquals(6.0, ans);
    }
    @AfterAll
    public static void setupAfterAll()
    {
        a = null;
    }
}