package trees;

import java.util.ArrayList;
import java.util.List;

public class FindAllLeaves {
    public int findHeight(TreeNode root, List<List<Integer>> listOfNodes)
    {
        if(root == null)
        {
            return -1;
        }

        int left = findHeight(root.left, listOfNodes);
        int right = findHeight(root.right, listOfNodes);

        int height = Math.max(left, right) + 1;

        // if the list of nodes contains the height (key) then append an empty ArrayList
        // to it to start collecting the nodes at that height.
        if(height == listOfNodes.size()) {
            listOfNodes.add(new ArrayList<>());
        }
        listOfNodes.get(height).add(root.val);
        // throw-away value
        return height;
    }
    public List<List<Integer>> findAllLeaves(TreeNode root)
    {
        /*
        Collect all leaves from the bottommost level of the tree to the root.
        Brute force approach: I can DFS down the tree for every node in the tree
        but that would take O(n^2) time.

        Approach:
        Group all nodes based on their height in a map or a list where the indices are the keys.
        Leaves have a height of 0.
        Height is the number of edges between a node and the deepest leaf.
         */
        List<List<Integer>> listOfNodes = new ArrayList<>();
        findHeight(root, listOfNodes);
        return listOfNodes;
    }
}
