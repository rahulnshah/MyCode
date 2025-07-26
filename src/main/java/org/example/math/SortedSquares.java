package org.example.math;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        /*
        Brute-Force: Use the sort() method, but this will take O(nlogn) time!
        Approach: Use two-ptrs similarly to how you would reverse a string.  Decrement/Incrment the pointer whose num squared is larger of the two.  When the pointers, cross, we stop and fill in the sq of the last num in our res array.
        T.C: O(n/2) -> O(n)
        */
        int l = 0, r = nums.length - 1, j = nums.length - 1;
        int [] res = new int[nums.length];
        while(l < r)
        {
            if(nums[l] * nums[l] <= nums[r] * nums[r])
            {
                res[j] = nums[r] * nums[r];
                r--;
            }
            else
            {
                res[j] = nums[l] * nums[l];
                l++;
            }
            j--;
        }
        res[j] = nums[l] * nums[l]; // or nums[r] * nums[r]
        return res;
    }
}
