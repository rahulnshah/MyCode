package arrays;

public class RotateArrayByK {
    public void reverseArr(int [] nums, int l , int r)
    {
        while(l < r)
        {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        // O(1) solution
        /*
        - reset value of k to k % nums.length ; so that if k == length no shifting needs to occur
        - reverse nums first
        - go from 0 to k - 1 and reverse that porition of nums (reversed earlier)
        - go from k to the end of nums and reverse this portion
        */
        k = k % nums.length;
        int l = 0;
        int r = nums.length - 1;

        reverseArr(nums, l, r);

        l = 0;
        r = k - 1;

        reverseArr(nums, l, r);

        l = k;
        r = nums.length - 1;

        reverseArr(nums, l, r);

        /*
        Tests: nums = [-1,-100,3,99]
        k = 2 % 4 = 2
        [-1,-100,3,99] -> [99,3,-100,-1] ->
        k - 1 = 1
        [3,99,-100,-1]

        l = k = 2
        r = 3
        [3,99,-1,-100]

        nums = [1]
        k = 1%1 = 0 (no rotation occurs)
        [1] -> [1]
        l = 0
        r = k - 1 = -1

        l = 0
        k = 0
        -> [1]

        nums = [1,2]
        k = 1%2 = 1
        [1,2] -> [2,1]
        l = 0
        r = k - 1 = 0
        l = k = 1
        r = 2 - 1 = 1
        -> [2,1]
        */
    }
}
