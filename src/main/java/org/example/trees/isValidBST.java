package org.example.trees;

public class isValidBST {
	public boolean valid(TreeNode root, long left, long right){
		if(root == null)
			return true;
		else if (!(left < root.val && root.val < right))
			return false;
		else
			return valid(root.left,left,root.val) && valid(root.right,root.val,right);
	    }
	   public boolean isValidBST(TreeNode root) {
	        /**
	            BF:
	            if node has a left child check that it is less than the root node
	            if node has a right child check that it is greater than the root node
	            if node is null, return true 

	            check both left a right trees are both BSTs 

	            But this solution above falls short.  Why? Because u can have a number that is in the wrong spot way down the tree because it is not greater less than the root. 

	            2nd Approach: At each node, make sure every node below it is less than or greater than itself -> O(n^2) time

	            Better Approach:
	            Compare longs. long > int, because a long can accommodate a bigger range of numbers than the range of node values this problem gives us.  
	         */
	         return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
	    }
}
