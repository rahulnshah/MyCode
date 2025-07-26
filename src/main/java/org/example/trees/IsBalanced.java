package org.example.trees;

public class IsBalanced {
	public int maxDepth(TreeNode root) {

        /** This is problem is basically "Find the height of the tree" 
        
            Recursive Approach: 
            Height of a leaf node is 1 here 
            Height of root is then 1 + maxDepth(left subtree, right tree)

            Base case: If node is null, then return 0, because we want leaf to be of depth 1
         */

         if(root == null)
         {
            return 0;
         }

         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
    public boolean isBalanced(TreeNode root) {
        /**
            BF approach: can traverse down the tree.  If Math.abs(left subtree height - right subtree height) > 1, then return False 

            Base case: if node is null, then you don't wanns traverse left and right subtrees because a node like that won;t have any subtrees, so it's subtree is tehnically balanced so return true. 
            
            If node is not null, it may have left and right subtrees so check if the heights of both don't differ by > 1.  If they do, return false. Then check if the left and right subtrees of that node are balanced by making two recursive calls. 
         */
         if(root == null)
         {
            return true;
         }

         int heightOfLeft = maxDepth(root.left);
         int heightOfRight = maxDepth(root.right);

         if (Math.abs(heightOfLeft - heightOfRight) > 1)
         {
             return false;
         }

         return isBalanced(root.left) && isBalanced(root.right);
    }
}
