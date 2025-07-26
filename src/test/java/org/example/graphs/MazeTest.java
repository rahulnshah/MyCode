package org.example.graphs;

import org.example.graphs.Maze;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    private static org.example.graphs.Maze a;
    @BeforeAll
    public static void setupBeforeAll()
    {
        a = new Maze();
    }
    @Test
    void bfs() {
        int srow = 0, scol = 4;
        int drow = 4, dcol = 4;

        int [][] grid = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        assertTrue(a.solveMaze(grid, srow, scol, drow, dcol));

    }

    @Test
    void bfs1() {
        int srow = 0, scol = 4;
        int drow = 4, dcol = 2;

        int [][] grid = {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };
        assertFalse(a.solveMaze(grid, srow, scol, drow, dcol));

    }

    @AfterAll
    public static void setupAfterAll()
    {
        a = null;
    }
}