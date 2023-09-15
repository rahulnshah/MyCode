package strings;

import arrays.IntersectionOfMultipleArr;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindGreaterPermutTest {

    private static FindGreaterPermut a;
    @BeforeAll
    public static void setupBeforeAll()
    {
        a = new FindGreaterPermut();
    }
    @Test
    void rearrangeWord() {
        String s = "baca";
        assertEquals("bcaa", a.rearrangeWord(s));
    }
    @AfterAll
    public static void setupAfterAll()
    {
        a = null;
    }
}