package intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        /*
        Since we merge all overlapping intervals the result will be non-overlapping

        - First sort the intervals by start value of each interval in ascending order,
        - then loop the list of intervals, such that i > 0 and see if the interval falls the perviou interval and if it does, put it in the returning matrix

        Time : O(nlogn) because of sorting, where n is number of given intervals

        Notes:
        - use a List of lists, then add it to a matrix becuse you don't know length of matrix from start
        */
        //First sort the intervals by start value of each interval in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int [] interval : intervals)
        {
            // merged is empty or no overlap found btw current interval and last appended interval in merged, append the current interval to the List
            if(merged.isEmpty() || merged.getLast()[1] < interval[0])
            {
                merged.add(interval);
            }
            else
            {
                int [] overLappedInterval = merged.getLast();
                overLappedInterval[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        // fill in matrix
        return merged.toArray(new int[merged.size()][]);
    }
}
