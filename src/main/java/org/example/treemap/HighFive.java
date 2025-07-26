package org.example.treemap;

import java.util.*;
public class HighFive {
    /*
    We're given student id's and their scores.
    We have to return the avg core of the top 5 scores of each student in increasing order.
    */

    /*
    Approach: Use a treemap which has the id as key and a pq as value which stores the scores of each student in increasing order (maxheap).

    Fill in the TreeMap

    Loop the treemap keys in order:
        Calculate the sum and avg for each id
        Store the id and avg in a List, and append the list in bigger List

    Time : O(nlog) cuz each insertion into treemap take logn and we're inserting n ids.
    Space: O(n) cuz there are n key value pairs in treemap
    */
    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new TreeMap<>();

        // ans is the 2d matrix of size N * 2, where N is number of unique ids
        // items.length is at least 1
        for(int [] item : items)
        {
            int id = item[0];
            int score = item[1];
            // put id , [score1,....]
            Queue<Integer> maxHeap = (map.containsKey(id)) ? map.get(id) : new PriorityQueue<>(Comparator.reverseOrder());
            maxHeap.offer(score);
            map.put(id, maxHeap);
        }

        // get how many id's you collected
        int [][] ans = new int[map.keySet().size()][2];
        int index = 0;
        for(int id : map.keySet())
        {
            // calc the avg
            Queue<Integer> maxHeap = map.get(id);
            int sum = 0;
            for(int i = 0; i < 5; i++)
            {
                sum += maxHeap.poll();
            }
            int [] idAndAvg = new int[2];
            idAndAvg[0] = id;
            idAndAvg[1] = sum / 5;
            ans[index] = idAndAvg;
            index = index + 1;
        }

        return ans;
    }
}
