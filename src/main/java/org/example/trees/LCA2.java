package org.example.trees;


import java.util.HashSet;
import java.util.Set;

public class LCA2 {
    public TreeNode findLCA2(TreeNode p, TreeNode q)
    {
        // find the lowest common ancestor of p and q given the parent of each - all nodes are unique
        // approach: climb up the tree using p first adding nodes to a Set and then climb up to the tree using
        // q and if you happen to find q in set, return it
        Set<TreeNode> s = new HashSet<>();
        TreeNode temp = p;
        while(temp != null)
        {
            s.add(temp);
            temp = temp.parent;
        }
        temp = q;
        while(temp != null)
        {
            if(s.contains(temp))
            {
                break;
            }
            else {
                temp = temp.parent;
            }
        }
        return temp;
    }
}
