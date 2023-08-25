package dynamicprog;

public class Fibonacci {
    public int f(int n, int [] dp_arr)
    {
        if(n <= 1) {
            return n;
        }
        else if(dp_arr[n] == -1)
        {
            dp_arr[n] = f(n- 1, dp_arr) + f(n - 2, dp_arr);
        }
        return dp_arr[n];
    }
}
