package org.example.arrays;
import java.util.*;
public class MaxStockPrice
{
   public int calculateSum(int st, int en, int [] arr)
   {
      int sum = 0;
      for(int i = st; i <= en; i++)
      {
         sum += arr[i];
      }
      return sum;
   }
   public int solution(int [] prices, int k)
   {
      /*
      Return maximum sum of a subarray of k elements
      
      EX: [1,2,7,7,4,3,6] maximum = max(10,14,13) = 14
      
      BF:
      - cumulative max could be 0 since all prices are positive  
      - use sliding window and a set to keep track of distinct prices
      - move the right pointer; while(set contains prices[right]){left++} add price[right] to the set
      - when (right - left) + 1 == k; maxSum = Math.max(maxSum, calculateSum(right, left, prices));
      */
      int maxSum = 0;
      int left = 0;
      Set<Integer> s = new HashSet<>();
      for(int right = 0; right < prices.length; right++)
      {
         while(s.contains(prices[right]))
         {
            s.remove(prices[left]);
            left++;
         }
         s.add(prices[right]);
         if((right - left) + 1 == k)
         {
            maxSum = Math.max(maxSum, calculateSum(left, right, prices));
            left++;
         }
      }
      return maxSum;
   }


}