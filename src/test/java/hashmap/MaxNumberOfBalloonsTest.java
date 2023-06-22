package hashmap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxNumberOfBalloonsTest {
    private static MaxNumberOfBalloons balloons;
    @BeforeAll
    public static void setupBeforeAll()
    {
        balloons = new MaxNumberOfBalloons();
    }
    @Test
    public void test1()
    {
        String text = "balloon";
        assertEquals(1,balloons.maxNumberOfBalloons(text));
    }
    @Test
    public void test2()
    {
        String text = "";
        assertEquals(0,balloons.maxNumberOfBalloons(text));
    }
    @AfterAll
    public static void setupAfterAll()
    {
        balloons = null;
    }
}