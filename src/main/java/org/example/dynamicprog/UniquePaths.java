package org.example.dynamicprog;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        /*
        We can only move DOWN or RIGHT to get to the bottom right. One way to solve this problem is move
        either left or right and ask ourselves where we end up, "how many ways can I get to the bottom right from here?"

        Brute-Force - Use DFS

        Approach: Use caching to cache the ways to reach the bottom right if either you move down or right.
        If ur in the last row or last column, there is only one way to reach the bottom right.
        If ur in the bottom right square, again there is only one way to get to the bottom right.
        Since we can either move down or right from a square, we know the total ways to get to the bottom right is the number of ways to get there if u move down + number of
        ways to get there if you move right.
        */

        int [][] waysToReachDest = new int[m][n];

        // fill last row to 1
        Arrays.fill(waysToReachDest[m - 1],1);
        // fill last column to 1
        for(int i = 0; i < m; i++)
        {
            waysToReachDest[i][n - 1] = 1;
        }

        // now fill in the rest of waysToReachDest
        for(int r = m - 2; r >= 0; r--)
        {
            for(int c = n - 2; c >= 0; c--)
            {
                // the total ways to get to the bottom right is the number of ways to get there if u move down + number of ways to get there if you move right.
                waysToReachDest[r][c] = waysToReachDest[r][c + 1] + waysToReachDest[r + 1][c];
            }
        }

        return waysToReachDest[0][0];
    }
}
