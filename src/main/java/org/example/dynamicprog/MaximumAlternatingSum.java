package org.example.dynamicprog;

import java.util.*;
public class MaximumAlternatingSum {
    public long maxAlternatingSum(int[] nums) {
        /*
        Problem says "reindexing", which means only numbers at odd positions are to be negated
        */
        Map<List<Object>, Long> dp = new HashMap<>();
        /* Start and index 0 and look for the max sum if we start at this index.
        * isEven is true because the first number in the subsequence, if we take it is to be added*/
        return dfs(0, true, nums, dp);

    }

    public long dfs(int ind, boolean isEven, int [] nums, Map<List<Object>, Long> dp)
    {
        if(ind == nums.length)
        {
            /* returning 0 here because the max sum of an empty array is 0 */
            return 0;
        }
        if(dp.containsKey(Arrays.asList(ind, isEven)))
        {
            /* caching: if we know the max sum at the ind and given if the number isEven or not, return that */
            return dp.get(Arrays.asList(ind, isEven));
        }
        /* if at the even index,
        take add nums[ind]
        else substract nums[ind]
        then take the max of that and when we do not include nums[ind] */
        long addAmt = isEven ? nums[ind] : -1 * nums[ind];
        dp.put(Arrays.asList(ind, isEven), Math.max(addAmt + dfs(ind + 1, !isEven, nums, dp), dfs(ind + 1, isEven, nums, dp)));
        return dp.get(Arrays.asList(ind, isEven));
    }
}
