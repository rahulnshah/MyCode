package org.example.arrays;
import java.util.*;
public class MinMovesToSortArrII{
   public int Solution(int [] arr)
   {
      /*
      Given an array of distinct numbers, find min moves to sort in asc order
      */
      int [] copyOfArr = new int[arr.length];
      for(int i = 0; i < copyOfArr.length; i++)
      {
         copyOfArr[i] = arr[i];
      }
      // sort original arr
      Arrays.sort(arr);
      //compare like so:
      int j = 0;
      int ans = arr.length;
      for(int i = 0; i < copyOfArr.length; i++)
      {
         if(copyOfArr[i] == arr[j])
         {
            j++;
            ans--;
         }
      }
      return ans;
      /*
      ans = 3-1 = 2 - 1 = 1
      i = 0, 1, 2, 3
      j = 0, 1, 2
      copyOfArr = 1,3,2
      sortedArr = 1,2,3
      
      ans = 4 - 1 = 3 - 1 = 2
      i = 0, 1, 2, 3, 4
      j = 0, 1, 2
      copyofarr = 5,1,3,2
      sortedarr = 1,2,3,5
      
      ans = 4 - 1 = 3 - 1 = 2
      i = 0, 1, 2, 3, 4
      j = 0, 1, 2
      copyofarr = 1,3,2,5
      sortedarr = 1,2,3,5
      
      ans = 0 
      i = 0, 1, 2, 3, 4
      j = 0, 1, 2, 3, 4
      copyofarr = 1,2,3,4
      sortedarr = 1,2,3,4
      
      */
   }

}