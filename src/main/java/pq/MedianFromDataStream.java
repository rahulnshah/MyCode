package pq;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFromDataStream {
    /* Brute force :
    could maintain a static array called list, in which I insert all nums in sorted order, so addnum will take O(n) time and findMedian? I could get that in O(1) time bitch

    This soln works but leetcode won't accept it

    Efficient Solution:
    Have two heaps, large and small, minheap, maxheap
    Heaps should have a size diff of <= 1
    */
    // init an empty array
    private static Queue<Integer> minheap;
    private static Queue<Integer> maxheap;
    public MedianFromDataStream() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {

        maxheap.offer(num);
        // largest element in maxheap is bigger than smallest element in minheap - then we have a problem
        // think of how quicksort is solved - all elements left of a pivot are smaller than those on the right of the pivot
        if(minheap.size() > 0 && maxheap.size() > 0 && maxheap.peek() > minheap.peek())
        {
            minheap.offer(maxheap.poll());
        }

        // uneven size of two heaps

        // if maxheap is bigger than minheap by size diff of 1, pop the largest element from it, push it to minheap
        if(maxheap.size() > minheap.size() + 1)
        {
            minheap.offer(maxheap.poll());
        }
        // if minheap is bigger than maheap by size diff of 1, pop the smallest element from it, push it to maxheap
        if(minheap.size() > maxheap.size() + 1)
        {
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian() {
        // get the max from max heap any way
        if(minheap.size() > maxheap.size())
        {
            return minheap.peek();
        }
        else if(minheap.size() < maxheap.size())
        {
            return maxheap.peek();
        }
        else
        {
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        }
    }
}
