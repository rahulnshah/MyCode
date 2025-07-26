package org.example.hashset;
import java.util.*;
public class LongestConsSequence{
	public int longestConsecutive(int[] nums) {
        /*
        start: 10:04 end: 10:34
        Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence. 
        
        Consecutive means 1 after the other.
        
        BF:
        - Could sort the nums, and loop until length - 1 checking the difference between 
        - adjacent nums until it is not 1 and compare the length if it is > 0 and that way return the max length, but sorting would take O(nlogn) time.  Minmaliest length is 0
        
        2nd method:
        - Take all nums in nums and put them in a Set because duplicates don't matter for this problem. 
        - Loop nums and get the start value of each seq. by checking whether current num in nums has a left neighbor 
            - if it does not, keep a counter of the consLength and loop from current num, keep adding a 1 to it and check if that sum exists in the set, stop looping when it does not 
                - check if consLength > longestLenght and if it is, reset longestLength 
        - return longestLength 
            
        */
        
        // default lenght is 0 if nums.length is 0
        int longLenOfConsNums = 0;
        
        // put all nums in a Set 
        Set<Integer> uniqueNums = new HashSet<Integer>();
        
        for(int num : nums)
        {
           uniqueNums.add(num); 
        }
        
        for(Integer num : uniqueNums)
        {
            if(!uniqueNums.contains(num - 1))
            {
                //start counting the range 
                int consLength = 1; //we're already on the first num of range 
                int currentNum = num;
                while(uniqueNums.contains(currentNum + 1))
                {
                    currentNum++;
                    consLength++;
                }
                longLenOfConsNums = Math.max(longLenOfConsNums, consLength);
            }
        }
        return longLenOfConsNums;
    }
}