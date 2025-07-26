package org.example.hashmap;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {
    // map the indices to the non-zero values in a vector
    private Map<Integer, Integer> m = new HashMap<>();

    public SparseVector(int [] nums)
    {
        // fill up m
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                m.put(i, nums[i]);
            }
        }
    }

    public int getDotProduct(SparseVector a)
    {
        // we want to iterate over the smaller map and compute the dot product that way for efficiency (less iterations)
        // assume the smaller vec is this vec
        Map<Integer, Integer> smallerVec = this.m;
        Map<Integer, Integer> largerVec = a.m;

        if(largerVec.size() < smallerVec.size())
        {
            Map<Integer, Integer> temp = smallerVec;
            // lost the ref to smallerVec
            smallerVec = largerVec;
            largerVec = temp;
        }

        // compute dotProduct
        int dotProduct = 0;
        for(Integer index : smallerVec.keySet())
        {
            dotProduct = dotProduct + smallerVec.get(index) * largerVec.getOrDefault(index, 0);
        }
        return dotProduct;
    }
}
