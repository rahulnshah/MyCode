package graphs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveDepthFirstSearchTest {

    private static RecursiveDepthFirstSearch a;
    @BeforeAll
    public static void setupBeforeAll()
    {
        a = new RecursiveDepthFirstSearch();
    }
    @Test
    void dfs() {
        List<List<Integer>> adjList = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(),
                        Arrays.asList(3,4),
                        Arrays.asList(),
                        Arrays.asList()
                )
        );

        assertEquals(Arrays.asList(0,1,2,3,4), a.dfs(adjList.size(), adjList));
    }

    @Test
    void dfs1() {
        List<List<Integer>> adjList = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList()
                )
        );

        assertEquals(Arrays.asList(0,1), a.dfs(adjList.size(), adjList));
    }
    @AfterAll
    public static void setupAfterAll()
    {
        a = null;
    }
}