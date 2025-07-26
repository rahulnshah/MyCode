package org.example.hashmap;
import java.util.*;
public class SelfDescribingNumber{
   public boolean isSelfDescribing(int num) {
   
      /*
      Precond: num is positive (num > 0, number is of length N and each position is labeled from 0 to N - 1
      Ex: 2020 - > 0, 1, 2, 3
      2 Zeros 
      0 ones 
      2 twos 
      0 threes 
      Ans: is self desc. 
      
      Efficient solution:
      Seems like frequency is the number above the index
      - convert int num to a string 
      - Create a map of indices 0 - 9 -> freq. (initailly 0), to get the indices, I need to get the length of string version of num
      - loop the string from 0 to its length - 1 (numbers that appear in string are from 0 to N - 1 where N is N digits in num)
         - put(i, 0) for now 
      - loop the string again and check if .get(i) == Integer.parseInt(s.substring(i, i+1 )) in string;
         - if not return false
      - return true 
      
      Time: O(n)
      Space: O(n)
      
      2nd Method:
      - Firstly all the digits get extracted from the outer loop and are stored in a variable b in each iteration. 
      - Then in the inner loop there is a count on how many times number i (this i is ith index of outer loop) is present in the string. 
      - Finally that count is compared with the digit present at the ith index stored in variable b.  
      
      Time: O(n^2)
      Space: O(1)
      
      */
      // converting the integer num to string
      String s = Integer.toString(num);
      Map<Integer, Integer> idxToFreq = new HashMap<>();
      
      for(int i = 0; i < 10; i++)
      {
         idxToFreq.put(i, 0);
      }
      
      // fill in the map
      for(int i = 0; i < s.length(); i++)
      {
        idxToFreq.put(Integer.parseInt(s.substring(i, i + 1)), idxToFreq.get(Integer.parseInt(s.substring(i, i + 1))) + 1); 
      }
      //copare if the number above indx matches with its freq. from map 
      for(int i = 0; i < s.length(); i++)
      {
         if(idxToFreq.get(i) != Integer.parseInt(s.substring(i, i + 1)))
         {
            return false;
         }
      }
      return true;
   }

}