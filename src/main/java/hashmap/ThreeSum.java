package hashmap;

import java.util.*;

class ThreeSum{
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        Given an integer array nums, return all three numbers with unique indices in a big List which add up to 0
        
        Cannot contain duplicate triplets in List 
       
        BF:
        - can loop, nums three times nested but that would take about O(n^3) times 
        
        2nd method:
         - Sort the nums so as to make it easier to avoid duplicate triplets (first value a, will be grouped together)
         - When you have the first value in the outer loop, loop the inner loop, use Two Sum II algorithm to find the two other nums tat along with a add up to 0 
         - nums is sorted so we can use Two Sum II algorithm in this problem
        
        Time: O(nlogn) becasue of sorting + O(n^2) because of two sum = O(n^2)
        Space: O(n) or O(1) depends on sorting library implementation 
        */
        List<List<Integer>> ans = new ArrayList<>();
        
        //sort nums 
        Arrays.sort(nums);
        
         for(int idxA = 0; idxA < nums.length; idxA++)
         {
             if(idxA > 0 && nums[idxA - 1] == nums[idxA]) //idxA needs to be > 0; we don't want to use the same a value twice; avoid duplicate a. 
             {
                 continue;
             }
             int remainingSum = 0 - nums[idxA];
             int left = idxA + 1; 
             int right = nums.length - 1;
             while(left < right)
             {
                if(nums[left] + nums[right] < remainingSum)
                {
                    left++;   
                }
                else if(nums[left] + nums[right] > remainingSum)
                {
                    right--;
                }
                else // you found two numbers that equal the sum (don't matter if they are dupes)
                {
                   List<Integer> triplet = new ArrayList<Integer>();
                   triplet.add(nums[left]);
                   triplet.add(nums[right]);
                   triplet.add(nums[idxA]);
                   ans.add(triplet);
                   left++;
                  // only update one pointer here, other conditions above will update the other pointer.  We do this ecause duplicate triplets are not allowed 
                   while(nums[left] == nums[left - 1] && left < right)
                   {
                    left++;   
                   }
                }
             }
             
             /*
             Test Cases:
             [-4,-1,-1,0,2] remSum = 0-(-1) = 1 [[-1, -1, 2]]
             [-2,0,1,1,2]
             */
         }
        return ans;
    }
}