package hashmap;
import java.util.*;
class CharacterReplacement {
    public int getCountOfMostFreqChar(Map<Character, Integer> mp)
    {
        // we can assume that there >= 1 character in mp because I cannot loop over an empty string 
        int maxFreq = 1;
        for(Character c : mp.keySet())
        {
            maxFreq = Math.max(maxFreq, mp.get(c));
        }
        return maxFreq;
    }
    public int characterReplacement(String s, int k) {
     /*
     Start: 8:15
     end : 8:45
     
     Given:
     - string s and integer k. 
     - can choose any character of the string and change it to any other uppercase English character
     - You can perform this operation at most k times.
     
     Return the length of the longest substring containing the same letter you can get after performing the above operations.
     
     2nd Method:
     - You can make <= k replacements
     - Since we have a limit on the number of replacements we can make, we are going to replace characters that occur less frequently in a window. 
        - In other words, we want each character in a window to match the most common character in that window. 
        - Keep number of occurences of each char in a map 
        - A valid window is one for which len(window) - count of most freq. char in window <= k
     Sliding window techinque:
     - Init left and right pointers at index 0 
     - As you increment the right pointer, update counts of the chars that right pointer is at 
     - Shift left pointer while (len(window) - count of most freq. char in window > k)
        - also decrement counts of the charachter the left pointer points to
     */
       int left = 0;
       int maxCount = 0;
       Map<Character, Integer> charToFreq = new HashMap<>();
       for(int right = 0; right < s.length(); right++)
       {
           if(charToFreq.containsKey(s.charAt(right)))
           {
               charToFreq.put(s.charAt(right), charToFreq.get(s.charAt(right)) + 1);
           }
           else
           {
               charToFreq.put(s.charAt(right), 1);
           }
           while(((right - left + 1) - getCountOfMostFreqChar(charToFreq)) > k)
           {
            charToFreq.put(s.charAt(left), charToFreq.get(s.charAt(left)) - 1);
            left++;
           }
           maxCount = Math.max(right - left + 1, maxCount);
       }
       return maxCount;
    }
}