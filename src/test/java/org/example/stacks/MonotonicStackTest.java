package org.example.stacks;

import org.example.stacks.MonotonicStack;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MonotonicStackTest {

    private static MonotonicStack a;
    @BeforeAll
    static void setUpBeforeAll() {
        a = new MonotonicStack();
    }

    @Test
    void test1() {
        assertArrayEquals(new int [] {3}, a.findBuildings(new int [] {1,3,2,4}));
    }

    @Test
    void test2() {
        assertArrayEquals(new int [] {0,2,3}, a.findBuildings(new int [] {4,2,3,1}));
    }

    @Test
    void test3(){assertArrayEquals(new int [] {0}, a.findBuildings(new int [] {4}));}

    @Test
    void test4(){assertArrayEquals(new int [] {3}, a.findBuildings(new int [] {2,2,2,2}));}

    @AfterAll
    static void tearDownAfterAll() {
        a = null;
    }
}