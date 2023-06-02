package Trees;
public class IsSameTree {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        /*
	        Given the roots of two binary trees p and q, write a function to    check if they are the same or not.

	        2nd Method:
	        We're gonna check quite literally if the trees are the same using  recursion.  

	        Edge cases:
	        if both nodes are null, return true
	        else if one of the nodes is null, return false 
	        else if both nodes are not null but their values don't match return false
	        else everything matches, so check left and right subtrees are equal
	        */

	        if(p == null && q == null)
	        {
	            return true;
	        }
	        else if(p == null || q == null)
	        {
	            return false;
	        }
	        else if(p.val != q.val)
	        {
	            return false;
	        }
	        else
	        {
	            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	        }
	    }
	}
