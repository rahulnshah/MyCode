package backtracking;
import java.util.ArrayList;
import java.util.List;
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        /*
        Basically, you are simulating a permutation tree like you would on paper

        In code, what is happening is you pick an element and as you go down its subtree, you pick an
        element from the list of currently available elements and call findPerms again to do the same thing    again and again until size of a permutation becomes same as nums, as all elements have been picked.

        Then you remove last picked element, and as the calls finish permutation becomes empty, and then you traverse down another branch of the desicion tree by picking abother element first time and so on.

        Time: O(n! * n), becase for each permutation, you loop nums n times, where n is its length
        Space:
        */

        List<List<Integer>> ans = new ArrayList<>();
        // initially, all values in frq are false
        boolean [] freq = new boolean[nums.length];
        findPerms(ans, new ArrayList<>(), freq, nums);
        return ans;
    }

    public void findPerms(List<List<Integer>> ans, List<Integer> permutation, boolean [] freq, int [] nums)
    {
        // base case
        if(permutation.size() == nums.length)
        {
            // add the permutation to ans
            ans.add(new ArrayList<>(permutation));
        }

        for(int i = 0; i < nums.length; i++)
        {
            // if num is avaiable to be picked, add it to permutation, and call findPerms again
            if(!freq[i])
            {
                // num[i] has been picked
                freq[i] = true;
                permutation.add(nums[i]);
                findPerms(ans, permutation, freq, nums);
                permutation.remove(permutation.size() - 1);
                // num[i] has been unpicked
                freq[i] = false;
            }
        }


    }
}
