package org.example.trees;
import java.util.List;
import java.util.ArrayList;
public class LevelOrderTraverse {
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
         This is Breadth-First Search.  Breadth-First Search uses a queue, but we can use a plain List here as well.

         Algorithm:
         if root exists, insert it in ans, and in children; assume root was a child of some parent
         if children.size() > 0;
         insert all children's vals into ans
         let the children become parents
         set children to empty List
         Gather new children from parents
         */

        List<List<Integer>> list = new ArrayList<>();
        List<TreeNode> children = new ArrayList<>();
        if(root != null)
        {
            children.add(root);
        }

        while(children.size() > 0)
        {

            // add the children (which is a temp ArrayList) at that level to list ArrayList
            List<Integer> temp = new ArrayList<>();
            for(TreeNode child : children)
            {
                temp.add(child.val);
            }
            list.add(temp);
            // make the TreeNode children parent
            List<TreeNode> parents = children;
            // reset the children array
            children = new ArrayList<>();

            // get the children of the parentNodes and add them to each list
            for(TreeNode parent : parents) {
                if (parent.left != null) {
                    children.add(parent.left);
                }
                if (parent.right != null) {
                    children.add(parent.right);
                }
            }
        }

        return list;
    }
}
