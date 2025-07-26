package org.example.intervals;

import java.util.LinkedList;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        You will add the intervals in sorted order into an empty ArrayList and
        merge them if need be as you loop the intervals matrix.

        Three cases to consider:
        if the current interval we are at in the loop comes
        - after newInterval
        - before newInterval
        - or needs to be merged with newInterval

        Time Complexity: O(n), Space Complexity: i*j
        */
        LinkedList<int[]> merged = new LinkedList<>();
        for(int i = 0; i < intervals.length; i++)
        {
            if(newInterval[1] < intervals[i][0])
            {
                merged.add(newInterval);
                // add the rest of the intervals now
                for(int j = i; j < intervals.length; j++)
                {
                    merged.add(intervals[j]);
                }
                return merged.toArray(new int[merged.size()][]);
            }
            else if(newInterval[0] > intervals[i][1])
            {
                merged.add(intervals[i]);
            }
            else
            {
                // time to merge newInterval with current interval
                newInterval = new int [] {Math.min(intervals[i][0],newInterval[0]), Math.max(intervals[i][1],newInterval[1])};
            }
        }
        // add newInterval if it was not added in the loop above
        merged.add(newInterval);
        return merged.toArray(new int[merged.size()][]);
    }
}
