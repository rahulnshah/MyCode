package arrays;

public class XElementsGreaterThanOrEqToX {
    public int specialArray(int[] nums) {
        /*
        Brute-Force : Sort the numbers in asc order so each number is bigger than the next
        Then we know that our x lies in [1,n] because nums will always be non empty
        x can then also be one of nums or between two nums in our sorted array.
        if we loop each num in nums, and we find that there are not num[i] nums greater than equal to num,
        we can check if the number of ints between the current num we're on and the end of the array
        - meaning our x is between the current num we're on in the loop and the num before that, and if so, return our x
        if we don't return in the loop, return a -1 at the end.

        T.C: O(nlogn)

        Approach: We know we have to return  a number x such that there are exactly x numbers in nums that are greater than or equal to x. nums.length is atleast 1 so our soln is in [1,n].
        Bucket sort, since we know our solution will be between [1,n],
        we can make an array indexed from [0,1...n].
        Then we run a loop counting all numbers >= n and inc counts of other numbers as well
        We loop of count array and return when index matches with the index element
        */
        int [] c = new int[nums.length + 1];

        // loop 1
        for(int num : nums)
        {
            if(num >= c.length - 1) // n
            {
                c[c.length - 1]++;
            }
            else
            {
                c[num]++;
            }
        }
        // loop 2
        for(int i = c.length - 2; i >= 1; i--)
        {
            c[i] += c[i + 1];
        }

        // loop 3
        for(int i = 1; i < c.length; i++)
        {
            if(i == c[i])
            {
                return i;
            }
        }
        return -1;
    }
}
