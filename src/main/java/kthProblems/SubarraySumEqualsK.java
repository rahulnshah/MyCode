package kthProblems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        /*
        Approach: If sum_j - sum_i = k, then sum_i = sum_j - k.
        Keep a counter of the num of subarrays that add up to k.
        Keep track of the current cum sum (sum_j) and see if sum_j - k exists
        and if so, add the freq. of it to count.
        if the current cum sum is not in the hashmap, add it to the has map (sum_i).
        return count.

        TC: O(n)
        SC: O(n)
        */
        int count = 0, currentSum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        // we do this, because currently the currentSum is 0
        mp.put(0,1);
        for(int num : nums)
        {
            currentSum += num;
            if(mp.containsKey(currentSum - k))
            {
                count += mp.get(currentSum - k);
            }

            if(!mp.containsKey(currentSum))
            {
                mp.put(currentSum, 1);
            }
            else
            {
                mp.put(currentSum, mp.get(currentSum) + 1);
            }
        }

        return count;
    }
}
