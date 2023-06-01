package arrays;
import java.util.*;
public class MinMovesToSortArray{
   public int solution(int [] arr)
   {
      /*
      Given an array of distinct integers in range [1,N], you may sort it by moving any element to the end of the array.
      Find the minimum number of moves to sort the array in increasing order.
      
      2nd method: LinkedList Cycle
      - Make a boolean array isVisited which by default saves all bools as false
      - Make a hashmap storing index (1-based) as key and value corresponding to that index; hashmap is not necessary here; used for simplicity
      - 
      */
      boolean [] isVisited = new boolean[arr.length + 1]; // 0 , 1, ... N
      Map<Integer,Integer> nodeMap = new HashMap<>();
      //store elements in the hashmap 1:elelemnt at index 0 in arr, 2:element at index 1 in arr ... N:element at index N - 1 in arr
      for(int i = 1; i < isVisited.length; i++)
      {
         nodeMap.put(i, arr[i - 1]);
      }
      int minMoves = 0;
      // meat of the problem
      for(int i = 1; i < isVisited.length; i++)
      {
         if(i == nodeMap.get(i))
         {
         //mark as visited 
            isVisited[i] = true;
            continue;
         }
         // mark as visited too
         isVisited[i] = true;
         // i (1-based index does not match corresponding element)
         int c = nodeMap.get(i);
         while(!isVisited[c])
         {
            c = nodeMap.get(c);
            minMoves++;// 1 addition to this var = 1 swap
         }
      }
      return minMoves;
   }
}
