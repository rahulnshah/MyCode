package deques;
import java.util.*;
public class SlidingWindowMaximum
{
  public int[] maxSlidingWindow(int[] nums, int k) {
      int n = nums.length;
      int [] output = new int[n - k + 1];
      int right = 0;
      int left = 0;
      int i = 0;
      //will store indices 
      Deque<Integer> q = new ArrayDeque<>();
      
      while(right < n)
      {
         // before we are allowed to append an element to our queue, we have to 
         // check that no smaller elements exist in our queue.
         // pop smaller values from q
         while(!q.isEmpty() && nums[q.peekLast()] < nums[right])
         {
            q.pollLast();
         }
         
         q.offerLast(right);
         // remove leftmost index from window if it is out of bounds of the current window of k elemnts 
         
         //Time: O(n)
         //Space: O(n)
         if(left > q.peekFirst())
         {
            q.pollFirst();
         }
         if((right + 1) >= k)
         {
            output[i] = nums[q.peekFirst()];
            i++;
            left++;
         }
         right++;
      }
      return output;
  }
}