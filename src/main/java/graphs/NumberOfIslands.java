package graphs;

import java.util.*;

public class NumberOfIslands {
    public void bfs(int nrow, int ncol, char [][] grid, boolean [][] vis)
    {
        int n = grid.length, m = grid[0].length;
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(nrow, ncol)));

        // to represent the 4 directions I could traverse in a 2D matrix, like a grid
        int [] delRow = {0, 1, 0, -1};
        int [] delCol = {-1, 0, 1, 0};

        while(!q.isEmpty())
        {
            // take out first cell
            nrow = q.peek().get(0);
            ncol = q.peek().get(1);
            q.poll();

            // explore it neighbors
            for (int i = 0; i < 4; i++) { // only four directions
                int r = nrow + delRow[i];
                int c = ncol + delCol[i];
                if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == '1' && !vis[r][c]) {
                    q.add(Arrays.asList(r, c));
                    vis[r][c] = true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        /*
            Problem is same as find number of connected components.
            We're given at m by n matrix this time not n by n so we will not use
            an adj list, but we will use the grid it self to do bfs on.
            We will traverse in all 4 directions to touch all adj islands denote by a "1".
        */

        int n = grid.length, m = grid[0].length;
        boolean [][] vis = new boolean[n][m];
        int c = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == '1' && !vis[i][j])
                {
                    c++;
                    bfs(i, j, grid, vis);
                }
            }
        }

        return c;
    }
}
