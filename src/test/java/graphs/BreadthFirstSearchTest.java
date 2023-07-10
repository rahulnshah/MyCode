package graphs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import stacks.RemAllDupAdjInString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

    private static BreadthFirstSearch a;
    @BeforeAll
    public static void setupBeforeAll()
    {
        a = new BreadthFirstSearch();
    }
    @Test
    void bfs() {
        List<List<Integer>> adjList = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(),
                        Arrays.asList(3,4),
                        Arrays.asList(),
                        Arrays.asList()
                )
        );

        assertEquals(Arrays.asList(0,1,2,3,4), a.bfs(adjList.size(), adjList));

    }

    @Test
    void bfs1() {
        List<List<Integer>> adjList = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList()
                )
        );

        assertEquals(Arrays.asList(0,1), a.bfs(adjList.size(), adjList));

    }
    @Test
    void bfs2() {
        List<List<Integer>> adjList = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList()
                )
        );

        assertEquals(Arrays.asList(0), a.bfs(adjList.size(), adjList));

    }
    @AfterAll
    public static void setupAfterAll()
    {
        a = null;
    }
}