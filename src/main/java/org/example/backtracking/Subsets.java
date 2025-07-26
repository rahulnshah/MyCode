package org.example.backtracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubset(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }
    public void generateSubset(List<List<Integer>> subsets, List<Integer> subset, int [] nums, int index)
    {
        // add a copy of the current subset to subsets List
        subsets.add(new ArrayList<Integer>(subset));
        for(int i = index; i < nums.length; i++)
        {
            // add current element in subset
            subset.add(nums[i]);
            generateSubset(subsets, subset, nums, i + 1);
            // remove last added element from subset and explore a possibility without it
            subset.remove(subset.size() - 1);
        }
    }
}
