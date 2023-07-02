package binarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        /*
        Big assumptions in this problem:
        num[0] is always bigger than nums before/outside of the nums list
        last num is always bigger than the nums after/outside of the nums list
        Adjacent nums are not equal

        One approach (BF): You can treverse nums and see if a num is bigger than the pervious num and bigger than the num after it, if now continue searching.
        This is an O(n) time soln

        2nd approach: Apply binary search but only wen you know for sure that niether the very first or last elements are not peaks.
        If they are just return one of them, else do bin search for the peak between index 1 and n - 2.
        We also know that if nums has only one element that element itself is the only peak so return it

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
                    return mid; // we found our peak element so we return its index; the proble says it is garaunteed
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
