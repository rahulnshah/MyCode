package linkedlist;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        /*
        This problem is based of off linked list cycle and the floyd detection algorithm
        */
        int fast = nums[0];
        int slow = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast); // need to use do..while here because slow and fast start at same place obviously.

        // move the fast to starting point
        fast = nums[0];
        //return when slow and fast collide again; slow and fast will not be at same value right away

        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow; //or fast
    }
}
