package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
    public int minTotalDistance(int [][] grid)
    {
        // The grid dimensions
        int rows = grid.length;
        int cols = grid[0].length;

        // Lists to store the coordinates of all 1s (occupied places) in the grid
        List<Integer> rowCoordinates = new ArrayList<>();
        List<Integer> colCoordinates = new ArrayList<>();

        // Iterate through the grid to populate the lists with the coordinates of 1s
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    rowCoordinates.add(i);
                    colCoordinates.add(j);
                }
            }
        }

        // Sort the columns' coordinates as row coordinates are already in order because of the way they are added
        Collections.sort(colCoordinates);

        // Find the median of the coordinates, which will be our meeting point
        int medianRow = rowCoordinates.get(rowCoordinates.size() / 2);
        int medianCol = colCoordinates.get(colCoordinates.size() / 2);

        // find the minTotalDistance : |x1 - xmedian| + |y1 - ymedian| + |x2 - xmedian| + |y2 - ymedian| = |x1 - xmedian| +  |x2 - xmedian| + |y1 - ymedian| + |y2 - ymedian|
        return calculateDistance(rowCoordinates, medianRow) + calculateDistance(colCoordinates, medianCol);
    }
    public int calculateDistance(List<Integer> oneDCoords, int median)
    {
        int sum = 0;
        for (int coordinate : oneDCoords) {
            sum += Math.abs(coordinate - median);
        }
        return sum;
    }
}
