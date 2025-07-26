package org.example.backtracking;
import java.util.List;
import java.util.ArrayList;
public class CombinationSum {
    public void findCombinations(int index, int [] candidates, int target, List<List<Integer>> ans, List<Integer> combination){
        // base case
        if(index == candidates.length)
        {
            if(target == 0)
            {
                ans.add(new ArrayList<>(combination)); // add a copy not the actual List cuz you will modify it later on
            }
            return; // don't want to continue to next if or else u will go out of bounds
        }
        if(candidates[index] <= target)
        {
            combination.add(candidates[index]);
            findCombinations(index, candidates, target - candidates[index], ans, combination);
            combination.remove(combination.size() - 1);
        }
        findCombinations(index + 1, candidates, target, ans, combination); // don't subtract comb[ind] yet cuz you will if you add it in the next recursive call
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
        Approach: Same concept of taking an element and searching possibilities and not taking that same element and searching for those possibilities
        But you want node of the combinantion in one side, for exmaple the left subtree to not match the ones in the right subtree.  A plain descion tree will not give you unique combinations.
        When you reach a combination that adds up to the target, you can stop there since, our candidates consist of positive integers only.

        */

        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
