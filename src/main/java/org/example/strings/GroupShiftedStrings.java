package org.example.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        /*
        We will group strings according to the differences between adjacent letters in
        each string (our key). If a string is of length 1, then we will put -1 as the key, since
        does not exist another letter in that string to get a difference.
         */
        Map<String, List<String>> mp = new HashMap<>();
        for(String s : strings)
        {
            if(s.length() == 1)
            {
                if(!mp.containsKey("-1"))
                {
                    mp.put("-1", new ArrayList<>());
                }
                mp.get("-1").add(s);
            }
            else
            {
                // compute the key
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < s.length() - 1; i++)
                {
                    // I do diff % 26 to account for wrap-around
                    sb.append(String.valueOf((s.charAt(i + 1) - s.charAt(i)) % 26));
                }
                if(!mp.containsKey(sb.toString()))
                {
                    mp.put(sb.toString(), new ArrayList<>());
                }
                mp.get(sb.toString()).add(s);
            }
        }
        return new ArrayList<>(mp.values());
    }
}
