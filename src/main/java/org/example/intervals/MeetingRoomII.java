package org.example.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomII {
    public int minMeetingRooms(List<Interval> intervals) {
        // 0 meetings means 0 days to hold them on
        if(intervals.size() == 0)
        {
            return 0;
        }

        // sort the intervals by start times
        intervals.sort(Comparator.comparingInt(a -> a.start));
        // store the start time values separately
        List<Integer> starts = new ArrayList<>();

        for(Interval interval : intervals)
        {
            starts.add(interval.start);
        }

        // sort the intervals by end times
        intervals.sort(Comparator.comparingInt(a -> a.end));
        // store the end time values separately
        List<Integer> ends = new ArrayList<>();

        for(Interval interval : intervals)
        {
            ends.add(interval.end);
        }

        /*
        Now we want to set a ptr on each start and end times arrays and compare
        both.
        If start time is less than and end time, inc. our counter because a meeting has to start before it can end
        If end == start, a meeting has ended so we dec. our counter. Will start > end ever? No, because all starts are < end.
        When we finish looping all the start times, we will return our counter, which will tell us the remaining amount of meetings that are still going on
        */

        int res = 0, c = 0, s = 0, e = 0;
        while(s < starts.size())
        {
            if(starts.get(s) < ends.get(e))
            {
                s++;
                c++;
            }
            else // end[e] == start[s]
            {
                e++;
                c--;
            }
            res = Math.max(res, c);
        }

        return res;
    }

}
