package org.example.hashset;
import java.util.*;
class HappyNumber {
    public boolean isHappy(int n) {
       /*
       Write an algorithm to determine if a number n is happy.
       
       A happy number is a number defined by the following process:

      Starting with any positive integer, replace the number by the sum of the squares of its digits.
      Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
      Those numbers for which this process ends in 1 are happy.
      Return true if n is a happy number, and false if not.
       start: 9:00
       end: 9:30 actual: 10:00
      
        - While we have not reached 1, we go through the individual digits of n, and sum up their squares, and then reset sum. 
        - If we have gotten to that sum before (use a Set for this), we know we are in a cycle, so we need to return false.  If the Set does not already contain that sum, continue and return true when sum is 1.
       */
        Set<Integer> seenSums = new HashSet<>();
        while(n != 1){
            String strInt = String.valueOf(n);
            int sumOfSqDigs = 0;
            for(int i = 0; i < strInt.length(); i++)
            {
                sumOfSqDigs += Math.pow(Integer.parseInt(strInt.substring(i, i + 1)), 2);
            }
            if(seenSums.contains(sumOfSqDigs))
            {
                return false;
            }
            seenSums.add(sumOfSqDigs);
            n = sumOfSqDigs;
        }
        return true;
    }
}