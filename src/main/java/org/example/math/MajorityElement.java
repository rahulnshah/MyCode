package org.example.math;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        /*
        Brute-Force soln: use a hashmap!
        Approach: We know that if an element appears move than n/2, it will not cancel the other elements
        in terms of it's count so it will be the majority element.  So we keep a count of the current element
        and if it is canceled, (cnt = 0) we reset it to the new element that we just saw. This is Moore's algorithm.
        T.C: O(n)
        */
        int el = nums[0], cnt = 0;
        for(int num : nums)
        {
            if(cnt == 0)
            {
                cnt++;
                el = num;
            }
            else if(num == el)
            {
                cnt++;
            }
            else
            {
                cnt--;
            }
        }

        return el;
    }
}
