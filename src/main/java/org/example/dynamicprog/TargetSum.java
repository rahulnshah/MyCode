package org.example.dynamicprog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSum {
    public int findWaysToSumToTargetSum(int[] nums, int target)
    {
        /* We optimize recursive solution by caching the ways of (index, currSum) in a HashMap */
        Map<List<Integer>, Integer> dp = new HashMap<>();
        return f2(0,0,nums, target, dp);
        /* T.C: O(N * T) S.C: O(N) - all possible ind */
    }

    public int f2(int ind, int currSum, int [] nums, int K, Map<List<Integer>, Integer> dp)
    {
        if(ind == nums.length)
        {
            return (currSum == K) ? 1 : 0;
        }
        if(dp.containsKey(Arrays.asList(ind, currSum)))
        {
            return dp.get(Arrays.asList(ind, currSum));
        }
        dp.put(Arrays.asList(ind, currSum), f2(ind + 1, currSum + nums[ind], nums, K, dp) + f2(ind + 1, currSum - nums[ind], nums, K, dp));
        return dp.get(Arrays.asList(ind, currSum));
    }

    /* recursive solution */
    public int findWaysToSumToTargetSum1(int[] nums, int target)
    {
        /* find ways to get to target sum from index 0 and current sum of 0 */
        return f1(0, 0, target, nums);
    }

    public int f1(int ind, int currSum, int K, int [] nums)
    {
        if(ind == nums.length)
        {
            return (currSum == K) ? 1 : 0;
        }
        return f1(ind + 1, currSum + nums[ind], K, nums) + f1(ind + 1, currSum - nums[ind], K, nums);
    }
}
