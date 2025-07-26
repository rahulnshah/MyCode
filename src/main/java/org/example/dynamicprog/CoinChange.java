package org.example.dynamicprog;
import java.util.*;
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        /*
        Problem: Given some sort of amount of money that we need to make up using different denoinations of coins 
        Things to consider: 
            a. Can we make up this amount with the amounts of coins we are given
            b. what is the few number of coins we need to make this amount.
        
        Classic DP problem:
        - A good way to think about these problems is just smaller subproblems 
        
        The smaller problems here are questions like what is the smallest number of coins needed to make up 0 cents? 1 cent? 2 cents? 3 cents> -> build to the larger problem 
        
        Method of attack:
        - make a dp array that will store the smallest number of coins to make up whatever amount we're on. 
        Ex: 
        - dp[0] is fewest number of coins we need to make up 0 cents. 0 coins 
        - dp[n] is fewest number of coins we need to make up n cents.
        - populate dp array return dp[amount]
        - first fill up dp array with something invalid like amount + 1
        
        Time: O(amount * coins)
        Space: O(amount)
        */
        
        int [] dp = new int[amount + 1];
        //fill up dp array with something invalid like amount + 1
        Arrays.fill(dp, amount + 1);
        //Optimization : sort the coins in asc. order 
        Arrays.sort(coins);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            // loop all the coins 
            for(int j = 0; j < coins.length; j++){
                //if the coin that we're looking at is <= the amount we're trying to make, than we should add that coin 
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]); //find smallest number of coins; dp[i - coins[j]] retunrs that smallest number of coins needed to make (i - coins[j]) remaining cents from dp array
                }
                else{
                    break;
                }
            }
        }
        
        if(dp[amount] < amount + 1) //# of coins are less than amount + 1
        {
         return dp[amount];
        }
        return -1;
        
    }
}