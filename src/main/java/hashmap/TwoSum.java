package hashmap;
import java.util.*;
public class TwoSum{
   /*
   Given an array of integers nums and an integer target, 
   return indices of the two numbers such that they add up to target.
   */
   public int[] twoSum(int[] nums, int target) {
      /*
      Problem assumes unique nums in nums array and each input would have exactly one solution. 
      BF: check for a combination that adds up to target by using nest. loops
      2nd method:
         - store numbers in nums if you cannot find the difference of a num and target inside hashmap
         - store num as key and it's index as value 
         - if you find a difference, store the index of that number in the retArray and get index of second num from map
         - x + y = target x = target - y, you're given y, looking for x in map.
         
         - Time: O(n)
         - Space: O(n)
      */  
      int [] twoNums = new int[2];
      Map<Integer, Integer> numsFromNums = new HashMap<>();
      for(int i = 0; i < nums.length; i++){
         if(numsFromNums.containsKey(target - nums[i]))
         {
            twoNums[0] = i;         
            twoNums[1] = numsFromNums.get(target - nums[i]);
         }
         numsFromNums.put(nums[i], i); // this will execute anyway, so I map all values in nums to their index
      }
      return twoNums;
   }
}