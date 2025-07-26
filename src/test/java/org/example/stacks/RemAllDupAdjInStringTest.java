package org.example.stacks;

import org.example.stacks.RemAllDupAdjInString;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemAllDupAdjInStringTest {
    private static RemAllDupAdjInString a;
    @BeforeAll
    public static void setupBeforeAll()
    {
        a = new RemAllDupAdjInString();
    }
    @Test
    void removeDuplicates() {
        assertEquals("ay", a.removeDuplicates("azxxzy"));
    }

    @Test
    void removeDuplicates1() {
        assertEquals("ca", a.removeDuplicates("abbaca"));
    }
    @AfterAll
    public static void setupAfterAll()
    {
        a = null;
    }
}