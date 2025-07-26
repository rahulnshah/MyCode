package org.example.linkedlist;

public class insertIntoCircularList {
    // Method to insert a node into a sorted circular linked list
    public ListNode insert(ListNode head, int insertValue) {
        ListNode node = new ListNode(insertValue);
        if(head == null)
        {
            // list is empty so insert the only node into it and return ref to it
            head = node;
            head.next = node;
            return head;
        }
        // list is not empty, so we will find the insertion point
        // init a prev pointer and a curr pointer to point to the next node
        ListNode prev = head;
        ListNode curr = prev.next;
        while(curr != head)
        {
            if(prev.val <= insertValue && insertValue < curr.val)
            {
                // insertion point found so that list is in asc order
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        // curr = head, so insert it between the max and min node and reset the pointers; prev will point to the max
        // and curr will point to the min here
        prev.next = node;
        node.next = curr;
        return head;
    }
}
