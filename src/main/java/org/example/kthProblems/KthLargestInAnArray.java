package org.example.kthProblems;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInAnArray {
    public int findKthLargest(int[] nums, int k) {
        /* -Brute force:
            - store all nums in a pq (min heap)
            - while size of min heap > k, take out smallest elements (e.g. use poll)
            - then return pq.poll()
        */
        Queue<Integer> minheap = new PriorityQueue<>();

        for(int num : nums)
        {
            minheap.offer(num);
        }

        while(minheap.size() > k)
        {
            minheap.poll();
        }
        return minheap.poll();
    }
}
