package org.example.binarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        /*
        Big assumptions in this problem:
        num[0] is always bigger than nums before/outside the nums list
        last num is always bigger than the nums after/outside the nums list
        Adjacent nums are not equal

        One approach (BF): You can reverse nums and see if a num is bigger than the previous num and bigger than the num after it, if now continue searching.
        This is an O(n) time solution

        2nd approach: Apply binary search but only when you know for sure that neither the very first or last elements are not peaks.
        If they are just return one of their indices, else do bin search for the peak between index 1 and n - 2.
        We also know that if nums has only one element that element itself is the only peak so return its index

        Time: 0(log n)
        */
        if(nums.length == 1){
            return 0;
        }
        else if(nums[0] > nums[1])
        {
            return 0;
        }
        else if(nums[nums.length - 1] > nums[nums.length - 2])
        {
            return nums.length - 1;
        }
        else
        {
            int left = 1, right = nums.length - 2;
            while(left <= right)
            {
                int mid = (left + right) / 2;
                if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                {
                    return mid; // we found our peak element, so we return its index; the problem says it is guaranteed
                }
                else if(nums[mid - 1] > nums[mid])
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
