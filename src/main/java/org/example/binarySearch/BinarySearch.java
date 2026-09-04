package org.example.binarySearch;

public class BinarySearch {
    public int iterativeBinarySearch(int [] nums, int target){
        int n = nums.length;
        int low = 0, high = n - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(target > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1; // target not found
    }

    public int recursiveBinarySearch(int [] nums, int target, int low, int high){
        if(low > high) {
            return -1; // target not found
        }
        int mid = (low + high) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        else if(target > nums[mid]) {
            return recursiveBinarySearch(nums, target, mid + 1, high);
        }
        else {
            return recursiveBinarySearch(nums, target, low, mid - 1);
        }
    }
}