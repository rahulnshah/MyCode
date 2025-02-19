package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logger {
    /*
    a logger system that receives a stream of messages along with their timestamps.
    Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being
    printed until timestamp t + 10).
    All messages will come in chronological order. Several messages may arrive at the same timestamp.
     */
    private Map<String, Integer> m;
    public Logger()
    {
        this.m = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message)
    {
        /*
        Cannot print already seen message till 10 seconds later. All messages will come in asc order of the timestamp.
        Can use a hashmap that stores the message -> List<timestamps>.
        If a message is not in hashmap put it in else it is in hashmap so get its last timestamp add 10 to it and see if it equals current time stamp and if so,
        add the current time stamp to that list and return true.
         */
        if(!this.m.containsKey(message) || m.get(message) + 10 == timestamp)
        {
            // store the latest timestamp
            this.m.put(message, timestamp);
            return true;
        }
        return false;
    }
}
