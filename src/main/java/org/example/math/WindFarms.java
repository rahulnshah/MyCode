package org.example.math;

import java.util.Arrays;

public class WindFarms {
    public int minTotalCost(int [] premium, int [] x, int [] y)
    {
        /*
        Problem is similar to BestMeetingPoint except we are give the x and y coords unsorted from the start.
        Approach:
        1) find the best center point
        2) find the distance to each farm from center point
        3) calculate total cost
         */
        int [] rowCoordinates = Arrays.copyOf(y, y.length);
        int [] colCoordinates = Arrays.copyOf(x, x.length);
        Arrays.sort(rowCoordinates);
        Arrays.sort(colCoordinates);
        // Find the median of the coordinates, which will be our meeting point
        int medianRow = rowCoordinates[rowCoordinates.length / 2];
        int medianCol = colCoordinates[colCoordinates.length / 2];

        int [] distance = new int[x.length];
        // calc Manhattan distance from (x[i], y[i]) to (medianRow, medianCol)
        for(int i = 0; i < distance.length; i++)
        {
            distance[i] = Math.abs(y[i] - medianRow) - Math.abs(x[i] - medianCol);
        }
        return calculateCost(premium, distance);
    }
    public int calculateCost(int [] premium, int [] distance)
    {
        int sum = 0;
        for(int i = 0; i < premium.length; i++)
        {
            sum += premium[i] * distance[i];
        }
        return sum;
    }
}
