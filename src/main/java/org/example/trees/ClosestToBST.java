package org.example.trees;

public class ClosestToBST {
    public void findClosest(TreeNode root, double target, int [] ans, double [] minDiff)
    {
        if(root == null) return;
        if(Math.abs(root.val - target) < minDiff[0] || Math.abs(root.val - target) == minDiff[0] && root.val < ans[0])
        {
            minDiff[0] = Math.abs(root.val - target);
            ans[0] = root.val;
        }
        if(root.val > target)
        {
            findClosest(root.left, target, ans, minDiff);
        }
        findClosest(root.right, target, ans, minDiff);
    }

    public int findClosestToBST(TreeNode root, double target)
    {
        int [] ans = {root.val};
        double [] minDiff = {Math.abs(root.val - target)};
        findClosest(root, target, ans, minDiff);
        return ans[0];
    }
}
