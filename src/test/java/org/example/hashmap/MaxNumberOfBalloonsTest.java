package org.example.hashmap;

import org.example.hashmap.MaxNumberOfBalloons;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxNumberOfBalloonsTest {
    private static org.example.hashmap.MaxNumberOfBalloons a;
    @BeforeAll
    public static void setupBeforeAll()
    {
        a = new MaxNumberOfBalloons();
    }
    @Test
    public void test1()
    {
        String text = "balloon";
        assertEquals(1,a.maxNumberOfBalloons(text));
    }
    @Test
    public void test2()
    {
        String text = "";
        assertEquals(0,a.maxNumberOfBalloons(text));
    }
    @AfterAll
    public static void setupAfterAll()
    {
        a = null;
    }
}