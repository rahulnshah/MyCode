package dynamicprog;

import java.util.*;
import java.io.*;

public class SubsetsSumToK {
    /*
    This problem is similar to SubsetSumEqualsK except that now the meaning of our target state changes:
    How many ways can we sum up to target from index 0 to index n - 1?

    T.C.:O(N * K) where K is target
    S.C.:O(N * K) -> this can be further optimized
     */
    public static int findWays(int nums[], int K) {
        int n = nums.length;
        int [][] dp = new int [n+1][K+1];

        /* there is only 1 way to get a sum of 0 by picking 0 elements (the empty subset) */
        dp[0][0] = 1;
    /*
        No matter how many elements you are considering (whether it's the first 1 element, the first 2 elements, or all n elements), it is always possible to achieve a sum of 0 by not selecting any elements from the array (again, the empty subset).
    */
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = 1;
        }
    /*
    dp[0][j] represents whether a sum of j (j > 0) can be achieved using zero elements from the array. This is impossible.
    */
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int notTaken = dp[i-1][j];
                int taken = 0;
                if (j >= nums[i-1]) {
                    taken = dp[i-1][j-nums[i-1]];
                }
                dp[i][j] = taken + notTaken;
            }
        }

        return dp[n][K];
    }
    int f(int ind, int target, int [] a)
    {
        if(target == 0) // ind can be anything
        {
            return 1;
        }
        else if(ind == 0) // ind has to be 0 and target has to be target
        {
            return a[ind] == target ? 1 : 0;
        }

        int notTake = f(ind - 1, target, a);
        int take = 0;
        if(a[ind] <= target)
        {
            take = f(ind - 1, target - a[ind], a);
        }
        return take + notTake;
    }
}
