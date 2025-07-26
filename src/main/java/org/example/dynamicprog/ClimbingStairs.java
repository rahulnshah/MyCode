package org.example.dynamicprog;

public class ClimbingStairs {
    public int climbStairs(int n) {
        /*
        A way to think abt this problem is given n how many district ways can i climb to the top.

        if n = 1, I can take only one step up
        if n = 2, I can take 1+1 or 2
        if n = 0, there is only one way to climb 0 steps, u take none so 1 way

        For an i between 2 and forward, I could have come to i from the previous step or two steps before i so dp[i] = dp[i - 1] + dp[i - 2]
        */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
