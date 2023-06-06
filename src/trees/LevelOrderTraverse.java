package trees;
import java.util.List;
import java.util.ArrayList;
public class LevelOrderTraverse {
	public List<List<Integer>> levelOrder(TreeNode root) {
        /**
            This is Breadth-First Search.  Breadth-First Search uses a queue.

            Alogrthm:
            Get the children at each level, 
            collect all in a list, 
            append the smaller list in bigger list and do this until, you reach the leaves, 
            	because leaves don't have children from which u can get the children below them 
         */

         List<List<Integer>> list = new ArrayList<>();
         List<Integer> children = new ArrayList<>();
         List<TreeNode> childrenTreeNodes = new ArrayList<>();
         if(root != null)
         {
             childrenTreeNodes.add(root);
             children.add(root.val);
         }

         while(children.size() > 0)
         {
            
            // add the children (which is a temp ArrayList) at that level to list ArrayList 
            list.add(children);
            // reset the children array
            children = new ArrayList<>();
            // make the TreeNode children parent 
            List<TreeNode> parentTreeNodes = childrenTreeNodes;
            childrenTreeNodes = new ArrayList<TreeNode>();
            // get the children of the parentNodes and add them to each list 
            for(TreeNode firstOutNode : parentTreeNodes)
            {
                if(firstOutNode.left != null)
                {
                    childrenTreeNodes.add(firstOutNode.left);   
                    children.add(firstOutNode.left.val);
                }
                if(firstOutNode.right != null)
                {
                    childrenTreeNodes.add(firstOutNode.right);   
                    children.add(firstOutNode.right.val);
                }
            }
            // in next iteration, if there were any new children added, they are ready to become parent
         }

         return list;
    }
}
