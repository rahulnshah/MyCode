package org.example.trees;


public class ConvertBSTTODLL {
    // will point to the smallest number in tree
    TreeNode head = null;
    // will point to the largest number in tree
    TreeNode tail = null;

    // T.C. - O(n) and S.C - O(n)
    public void dfs(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        // do in-order traversal on BST to get the TreeNodes to fit in asc order
        dfs(root.left);
        /*
        if tail is set to null, then so is head, so if tail is null, set both head and tail to root
        if tail is not null, then tail.right is equal to current node, root and root.left is equal to tail
         */
        if(tail != null)
        {
            root.left = tail;
            tail.right = root;
        }
        else {
            head = root;
        }
        // reset tail to point to the next largest element
        tail = root;
        dfs(root.right);
    }
    public TreeNode treeToDoublyList(TreeNode root)
    {
        dfs(root);
        // close both ends on the DLL and return head
        head.left = tail;
        tail.right = head;
        return head;
    }
}
