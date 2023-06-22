package trees;

public class BinTreeMaxPathSum {
    public int maxPathSum(TreeNode root) {
        /*
        Algorithm: You want to keep track of the value of the max path do the tree
        1. U want to accommodate the case in which left + turning node + right node could give a max value and could be a valid path hence
        2. U want to accommodate the case in which node.val + max(left max path sum, right max path sum) could give a max value and could be a valid path hence
        Reset global max according to the top two cases

        Also, we want to ignore negative sums, cuz they won't give us a max path sum

        We will keep track of a global max using an array of length 1 in Java
        Let it initally represent Integer.MIN_VALUE


        */
        int [] globalMax = new int[1];
        globalMax[0] = Integer.MIN_VALUE;
        findMaxPathSum(root, globalMax);
        return globalMax[0];

    }
    public int findMaxPathSum(TreeNode root, int [] maxPathSum){
        if(root == null)
        {
            return 0;
        }
        int left = Math.max(0,findMaxPathSum(root.left, maxPathSum));
        int right = Math.max(0,findMaxPathSum(root.right, maxPathSum));
        maxPathSum[0] = Math.max(maxPathSum[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
