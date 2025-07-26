package org.example.arrays;

import org.example.arrays.IntersectionOfMultipleArr;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfMultipleArrTest {
    private static org.example.arrays.IntersectionOfMultipleArr a;
    @BeforeAll
    public static void setupBeforeAll()
    {
        a = new IntersectionOfMultipleArr();
    }
    @Test
    void intersection() {
        int [][] nums = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        List<Integer> res = new ArrayList<>(
                Arrays.asList(3,4)
        );
        assertEquals(res,a.intersection(nums));
    }
    @AfterAll
    public static void setupAfterAll()
    {
        a = null;
    }
}