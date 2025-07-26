package org.example.kthProblems;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    Queue<Integer> pQueue; /* min-heap */

    int kthlargest;

    public KthLargest(int k, int[] nums) {
        pQueue = new PriorityQueue<>();
        kthlargest = k;

        /* add elements from nums intot pQueue - O(n) time */
        for(int num : nums)
        {
            pQueue.offer(num);
        }
    }

    public int add(int val) {
        pQueue.offer(val);
        /* you need to focus on only k elements so add to the pQueue first val and then remove the elements while lenght of pQueue is > k */
        while(pQueue.size() > kthlargest)
        {
            pQueue.poll();
        }
        /* pop once again and return the popped elements as the kth largest element
        this is garaunteed */
        return pQueue.peek();
    }
}
