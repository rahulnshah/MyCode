package linkedlist;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        BF: add the sum literally and put all of the sums digit into a linkedlist but obviosuly leetcode won't accpet that soln

        2nd Approach: Remember there is always a carry when addding (defualt carry is 0)
                        Loop while l1 or l2 or there is a carry, add l1, l2, (backwards) and the carry , reassign carry, and make a ListNode each time of the val u get from that addition. The carry u get will be added to the next pair of v1, v2. 
        */
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0;
        while(l1 != null || l2 != null || carry != 0)
        {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry;
            // like is va1 = 15, carry will be 1
            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);

            // Update ptrs 
            curr = curr.next;
            if(l1 != null)
            {
                l1 = l1.next;
            }
            if(l2 != null)
            {
                l2 = l2.next;
            }

            // if we have a case like 8 + 7 = 15, we still to add the carry to an imaginary 0 in the tens place of 8 and 7
        }
        return dummy.next;
    }
}
