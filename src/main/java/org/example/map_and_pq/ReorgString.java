package org.example.map_and_pq;
import java.util.*;
public class ReorgString {
	public String reorganizeString(String s) {
        /*
        Approach: separate the most frequently occuring character by the next most frequently occuring character. This calls a HashMap to store the frequnecies and a priority queue to tell use the next most freq. occuring character. 
        */

        // get and store the freq. of each character in s  
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            // one - liner to know
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // we want our maxHeap with respect to however many times each letter in s has occured 
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        // populate our maxHeap - root contains the most freq. occuring character 
        for(char key : map.keySet())
        {
            maxHeap.add(key);
        }

        String result = "";
        while(maxHeap.size() > 1)
        {
            // get the most freq char, append it to result
            char current = maxHeap.remove();
            result += current;
            //get the next most freq char, append it to result
            char next = maxHeap.remove();
            result += next;
            //update freq. of each char
            map.put(current, map.get(current) - 1);
            map.put(next, map.get(next) - 1);
            // if there is still more of those characters left, add them back to the heap
            if(map.get(current) > 0)
            {
                maxHeap.add(current);
            }
            if(map.get(next) > 0)
            {
                maxHeap.add(next);
            }
        }

        // maxHeap.size() <= 1, so its 0 or 1
        // if there is only one character left in the heap and it's freq. > 1, we know we gotta reutnr a empty string, no other way around that 
        if(!maxHeap.isEmpty())
        {
            char lastChar = maxHeap.remove();
            if(map.get(lastChar) > 1)
            {
                return "";
            }
            result += lastChar;
        }
        return result;
        
    }
}
