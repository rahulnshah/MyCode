package org.example.hashset;

import org.example.hashset.MissingWords;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MissingWordsTest {

    public static org.example.hashset.MissingWords a;
    @BeforeAll
    public static void setupBeforeAll()
    {
        a = new MissingWords();
    }
    @Test
    void missingWords() {
        String s = "I like cheese";
        String t = "like";
        List<String> missingWords = Arrays.asList("I", "cheese");
        assertEquals(missingWords,a.missingWords(s,t));
    }

    @AfterAll
    public static  void tearDownAfterAll(){ a = null;}
}