package org.example.trees;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        Hey this is BST!  

        BF: Start a root node. both p and q need to be in same subtree to find the LCA.  
        Subproblem: If p and q < root search left 
                    If p and q > root search right
                    else split happens so that's when u return the root's val

        Case where root.val is equal to q or p then the other value could be in left subtree, right subtree, or be the root's value itself!  At this point you need to return the root's val 

        We have >= 2 nodes in the BST
        */

        if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;


    }
}
