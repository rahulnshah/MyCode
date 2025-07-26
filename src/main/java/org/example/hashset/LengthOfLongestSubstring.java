package org.example.hashset;
import java.util.*;
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        /* 
        Given a string s, find the length of the longest substring without repeating characters.
        
        BF:
        - get every single substring, check if it has an duplicate chars and if it doesn't then we're just gonna take the longest one of those strings 
        and return its length 
        Time: O(n^2)
        Space : O(1)
        
        2nd method : Use a Sliding window 
        - Let's make sure our window does not contain any duplicate chars
        - When your right pointer is at a dup char in the substring (or window), start shrinking your window (increment left pointer) until we do not have that duplicate char in the subsring. 
        - Else, add the rightmost char whose dup you removed earlier or who dup did not exist in the set yet.
        - recalculate max, increment right pointer 
        - Use a set to check if there is a duplicate char in the current substring (or window)
        
        Notes:
        - Adding and removing values from our set are quick ops 
        - nonrepeating substr has to be contiguous 
        
        Time: O(n)
        Space: O(n) - > all characters can be uniue potentially
        Tests:
        s = "a"
        s = "bbbbb"
        s = "abcabcbb" 3
        s = "pwwkew" 2 3
        */
        int left = 0;
        int maxCount = 0;
        Set<Character> nonrepeatingSubstringWindow = new HashSet<>();
        for(int right = 0; right < s.length(); right++)
        {
         while(nonrepeatingSubstringWindow.contains(s.charAt(right)))
         {
            nonrepeatingSubstringWindow.remove(s.charAt(left));
            left++;
         }
         nonrepeatingSubstringWindow.add(s.charAt(right));
         maxCount = Math.max(maxCount, (right - left) + 1);
        }
        return maxCount;
    }
}