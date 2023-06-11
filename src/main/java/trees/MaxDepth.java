package trees;

public class MaxDepth {
	public int maxDepth(TreeNode root) {

        /** This is problem is basically "Find the height of the tree" 
        
            Recursive Approach: 
            Height of a leaf node is 1 here 
            Height of root is then 1 + max depth of(left subtree, right tree)

            Base case: If node is null, then return 0, because we want leaf to be of depth 1
         */

         if(root == null)
         {
            return 0;
         }

         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
}
