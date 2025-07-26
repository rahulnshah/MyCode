package org.example.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumOfEnclaves {
    public int numEnclaves(int[][] grid) {
        /*
        - Example of a Multi-src bfs in which queue initially contains multiple nodes instead of just node and then do just bfs.

        grid[i][j] = 1 rep. land cell and 0 rep. sea cell
        Approach:
        - Start at the land cells around the boundary of grid and work your way in, visiting land cells that are directly connected to the boundary by some umber of moves.  We will use BFS for this.

        - At the end we will traverse the grid again and count cells that have not been vis, which will become our # of enclaves.

        */
        Queue<int []> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int [][] vis = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                // first row, first col, last row, last col
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1)
                {
                    if(grid[i][j] == 1)
                    {
                        q.add(new int[]{i, j});
                        vis[i][j] = 1;
                    }
                }
            }
        }

        // to represent the 4 directions I could traverse in a 2D matrix, like a grid
        int [] delRow = {0, 1, 0, -1};
        int [] delCol = {-1, 0, 1, 0};

        while(!q.isEmpty())
        {
            int [] temp = q.poll();
            int row = temp[0];
            int col = temp[1];

            // now traverse in all 4 directions and see which land cells in grid are directly connected to boundary
            for(int i = 0; i < 4; i++)
            {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                // Index out of bounds checking here
                if(nrow >= 0 && nrow < m && ncol < n && ncol >= 0 && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1)
                {
                    q.add(new int[]{nrow, ncol});
                    vis[nrow][ncol] = 1;
                }
            }
        }

        int cnt = 0;
        // see which lands remain within grid as enclaves
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1 && vis[i][j] == 0)
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
