package math;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        /*
        Approach & Intuition:
        - If you're looking for the smallest missing positive integer, it has to be bettwen 1 and len(nums) + 1

        - We're gonna use the input arrays nums as our "HashSet" to see if a number exists or not in it
        - Negative numbers are useles to us for this problem, so we can just "cross" them out by changing them to 0.  Why 0? Well cuz 0 is useless as well.

        - To tell that a value num[i]  existis in nums, we will take the abs valus of nums[i] and sub 1 from it and make the value of this diff as our index and negate the value at this index if it is not already.  Ignore indexes that are out of range of nums

        - If you compute index i, such that nums[i] = 0, set nums[i] = -(len(nums) + 1), which is out of bounds of [1,len(nums)], and len(nums) + 1 could be the worst case smallest positive integer returned
        */

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < 0)
            {
                nums[i] = 0;
            }
        }

        for(int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]);
            if(1 <= index && index <= nums.length)
            {
                if(nums[index - 1] > 0)
                {
                    nums[index - 1] *= -1;
                }
                else if(nums[index - 1] == 0)
                {
                    nums[index - 1] = -1 * (nums.length + 1);
                }
            }
        }

        // loop nums between 1 and nums.length and return the num at which nums[num - 1] > 0
        for(int i = 1; i <= nums.length; i++)
        {
            if(nums[i - 1] >= 0)
            {
                return i;
            }
        }

        return nums.length + 1;
    }
}
