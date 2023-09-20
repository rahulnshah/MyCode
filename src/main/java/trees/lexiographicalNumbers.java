package trees;

import java.util.ArrayList;
import java.util.List;

public class lexiographicalNumbers {
    /*
    Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
    You must write an algorithm that runs in O(n) time and uses O(1) extra space.

    Approach:
    The res array is getting filled up using dfs:
    1 gets added then 10..19 get generated as "nodes" and visited
    10 gets added then 100..109 get generated
    if n is 13, 100 is too huge so 1000..1009 do not get generated, same for 101 through 109
     */

    public void dfs(List<Integer> res, int first_digit, int n)
    {
        if(first_digit <= n)
        {
            res.add(first_digit);
            for(int i = 0; i < 10; i++)
            {
                dfs(res, first_digit * 10 + i, n);
            }
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int first_digit;
        for(first_digit = 1; first_digit < 10; first_digit++)
        {
            dfs(res, first_digit, n);
        }
        return res;
    }
}
