package trees;

public class SumRootToLeafNumbers {
    public int pathSum(TreeNode root, int currSum){
        if(root == null){
            return 0;
        }

        currSum = currSum * 10 + root.val;

        if(root.left == null && root.right == null){
            return currSum;
        }

        return pathSum(root.left, currSum) + pathSum(root.right, currSum);
    }
    public int sumNumbers(TreeNode root) {
    /*
    Basically start sum of a route with 0.
    as you dfs down the tree, mult. by 10 root.val and add it to sum.  return sum when ur on the leaf node. at the emd you want to return the sum of of the total sum of left and right subtrees.
    */
        return pathSum(root, 0);
    }
}
