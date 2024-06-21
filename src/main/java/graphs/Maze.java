package graphs;

import java.util.*;

public class Maze {
    public boolean bfs(int srow , int scol, int drow, int dcol, int [][] grid, boolean [][] vis)
    {
        int n = grid.length, m = grid[0].length;
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(srow, scol)));

        // to represent the 4 directions I could traverse in a 2D matrix, like a grid
        int [] delRow = {0, 1, 0, -1};
        int [] delCol = {-1, 0, 1, 0};

        while(!q.isEmpty()) {
            // take out first cell
            int row = q.peek().get(0);
            int col = q.peek().get(1);
            q.poll();
            // if you found dest return true
            if (row == drow && col == dcol) {
                return true;
            }
            // explore it neighbors
            for (int i = 0; i < 4; i++) { // only four directions
                int r = row + delRow[i];
                int c = col + delCol[i];
                if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 0 && !vis[r][c]) {
                    q.add(Arrays.asList(r, c));
                    vis[r][c] = true;
                }
            }
        }
        // dest not reached
        return false;
    }

    public boolean solveMaze(int [][] grid, int srow, int scol, int drow, int dcol)
    {
        int n = grid.length, m = grid[0].length;
        boolean [][] vis = new boolean[n][m];
        return bfs(srow, scol, drow, dcol, grid, vis);
    }
}
