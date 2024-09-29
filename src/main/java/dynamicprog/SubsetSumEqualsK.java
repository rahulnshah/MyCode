package dynamicprog;

public class SubsetSumEqualsK {
    /*
    Problem: Given an array of positive integers, find if there exists a subarray or subseq such that
    all elements of it add up to K.

    Brute Force (Recursion):
    This problem is like combination sum, but we are not finding all possible combos, we are just finding one.

    How to solve problems like this:
    1. Express your states : (index, k)
    2. Explore all the possibilities: a[index] is part of subseq | a[index] not part of subseq.
    3. return true | false

    T.C: O(2^n) because we have 2 choices per element
    S.C: O(n) (stack-space)

    We can f(n - 1, k, a) beacause what we are asking is does there exist a target K from index 0 to n - 1 in a?

    Approach (dp):
    With recursion T.C is bad and we have repeated branches of execution so we can cut down that repeated work by
    using a 2D matrix storing [index][target].

    1. Fill out base cases in 2D matrix.
    2. Form the nested loops (# of states = # of loops)
    3 Fill up the 2D matrix

    T.C.:O(N * K) where K is target
    S.C.:O(N * K) -> this can be further optimized
     */
    boolean f(int ind, int target, int [] a)
    {
        if(target == 0)
        {
            return true;
        }
        else if(ind == 0)
        {
            return a[ind] == target;
        }

        boolean notTake = f(ind - 1, target, a);
        boolean take = false;
        if(a[ind] <= target)
        {
            take = f(ind - 1, target - a[ind], a);
        }
        return take || notTake;
    }

    boolean f1(int [] a, int K)
    {
        int n = a.length;
        boolean [][] dpMatrix = new boolean[n][K+1];
        // fill out base cases
        for(int i = 0; i < n; i++)
        {
            dpMatrix[i][0] = true;
        }
        if(a[0] <= K)
        {
            dpMatrix[0][a[0]] = true;
        }

        // loop the matrix
        for(int ind = 1; ind < n; ind++)
        {
            for(int target = 1; target <= K; target++)
            {
                boolean notTake = dpMatrix[ind - 1][target];
                boolean take = false;
                if(a[ind] <= target)
                {
                    take = dpMatrix[ind - 1][target - a[ind]];
                }
                dpMatrix[ind][target] =  take || notTake;
            }
        }
        return dpMatrix[n - 1][K];
    }
}
