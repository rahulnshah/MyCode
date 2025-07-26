package org.example.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GoodJavaCodeSnippetsTest {

    @Test
    void moveAll_ShouldMoveNegativeNumbersToRight() {
        int[] arr = {1, -3, 2, -5, 4, -7, 6};
        int[] expected = {1, 2, 4, 6, -3, -5, -7};

        GoodJavaCodeSnippets.moveAll(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void isPalindrome_ShouldReturnTrue_WhenStringIsPalindrome() {
        assertTrue(GoodJavaCodeSnippets.isPalindrome("racecar"));
        assertTrue(GoodJavaCodeSnippets.isPalindrome("noon"));
        assertTrue(GoodJavaCodeSnippets.isPalindrome("a"));
        assertTrue(GoodJavaCodeSnippets.isPalindrome(""));
    }

    @Test
    void isPalindrome_ShouldReturnFalse_WhenStringIsNotPalindrome() {
        assertFalse(GoodJavaCodeSnippets.isPalindrome("hello"));
        assertFalse(GoodJavaCodeSnippets.isPalindrome("world"));
    }

    @Test
    void switchAdjacentCharsOf_ShouldSwitchPairs() {
        assertEquals("bacs", GoodJavaCodeSnippets.switchAdjacentCharsOf("abcs"));
        assertEquals("ba", GoodJavaCodeSnippets.switchAdjacentCharsOf("ab"));
    }

    @Test
    void switchAdjacentCharsOf_ShouldHandleOddLength() {
        assertEquals("bacd", GoodJavaCodeSnippets.switchAdjacentCharsOf("abcd"));
    }

    @Test
    void findSum_ShouldCalculateRangeSum() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(15, GoodJavaCodeSnippets.findSum(arr, 4, 0)); // sum of all elements
        assertEquals(9, GoodJavaCodeSnippets.findSum(arr, 2, 0));  // sum of first 3 elements
    }

    @Test
    void findNumOfOccurences_ShouldCountCorrectly() {
        assertEquals(2, GoodJavaCodeSnippets.findNumOfOccurences("hello hello world", "hello"));
        assertEquals(0, GoodJavaCodeSnippets.findNumOfOccurences("hello world", "xyz"));
        assertEquals(3, GoodJavaCodeSnippets.findNumOfOccurences("aaaaa", "a"));
    }
}