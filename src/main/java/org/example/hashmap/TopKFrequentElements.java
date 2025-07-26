package org.example.hashmap;
import java.util.*;
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        We will do this problem using bucket sort algorithm
        Basically, make a freq map of num to number of times they occur
        We will us the freq map above to fill up the buckets in an Arraylist with numbers that occur index number of times; no element occurs 0 times so 0 index will have empty bucket.
        Then we can get the top freq elements
        Since we are returning top k freq elements length of the ans array will be k

        Also, the max number of buckets we can have is length of nums
        */

        int [] ans = new int[k];
        List<List<Integer>> buckets = new ArrayList<>(); // 0, 1, 2, 3 -> len 4 but if I had 3 elements 1 could occur all 3 times in nums
        Map<Integer, Integer> mp = new HashMap<>();

        // fill up buckets with empty buckets
        for(int i = 0; i < (nums.length + 1); i++)
        {
            buckets.add(new ArrayList<>());
        }

        // fill up freq map
        for(int num : nums)
        {
            if(!mp.containsKey(num))
            {
                mp.put(num, 1);
            }
            else
            {
                mp.put(num, mp.get(num) + 1);
            }
        }

        // now loop the map add fill up buckets in buckets ArrayList
        for(int num : mp.keySet())
        {
            int freq = mp.get(num);
            buckets.get(freq).add(num);
        }

        // now we want to start filling up the ans array - start from last index in buckets, and gather all numbers from there beacue last index means higher frequency, ignore empty buckets
        int index = 0;
        for(int i = buckets.size() - 1; i > 0; i--)
        {
            List<Integer> bucket = buckets.get(i);
            for(int j = 0; j < bucket.size() && k > 0; j++)
            {
                ans[index] = bucket.get(j);
                index++;
                k--;
            }

        }
        return ans;
    }
}