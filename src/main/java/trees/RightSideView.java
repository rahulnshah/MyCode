package trees;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        /*
        Traverse the right side of the tree from top most to root to the rightmost leaf in the tree; this is the base case meaning this is where you stop adding node values tothe List

        Call a helper method passing in a empty List and root of tree and recursively call the helper until root == null

        ^ this approach does do not work, cuz there can still be a node behind if root.right is missing

        2nd Method: Run BFS and add last element of each level to ans List
        */
        List<TreeNode> children = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(root != null)
        {
            // add it to ans an children
            children.add(root);
        }

        while(children.size() > 0)
        {
            ans.add(children.get(children.size() - 1).val);
            // make children into parents now
            List<TreeNode> parents = new ArrayList<>(children);
            // reset children to empty list
            children = new ArrayList<>();

            // loop parents and gather new children nodes
            for(TreeNode parent : parents)
            {
                if(parent.left != null)
                {
                    children.add(parent.left);
                }
                if(parent.right != null)
                {
                    children.add(parent.right);
                }
            }
        }

        return ans;
    }
}
