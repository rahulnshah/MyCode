package org.example.arrays;
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        /*
        Start: 2:21
        end : 2:51
        
        Return the maximum amount of water a container can store
        
        - You are given an integer array height of length n
        - n vertical lines; two endpoints needed to form the ith line (i, 0) and (i, height[i])
        - two pointers problem 
        - maximum water a container can hold is between the first and last line 
        
        - there is atleaste two lines in height array 
        
        Conceptual:
        It is not just the hieght of the water that matters here, the area that is formed by the water also matters 
        To calculate the area, you need only the height and the width 
        
        Sorting would not help here because that wold mess up the original width between two lines 
        */
        int left = 0;
        int right = height.length - 1;
        int maxA = Math.min(height[left], height[right]) * (right);
        /*
        BF: 
        - loop thoguh every single line except the last, and calucate the area between it and the other line (O(n^2) time )
        
        2nd Method:
        - init left and right pointers. if left height is < right height increment left pointer else decrement right pointer ; calculate area between the two, compare; keep doing this while left < right. 
        - it doesn't matter if left height is same as right height 
        
        Time : O(n)
        Space: O(1)
        */
        // I already checked the endpoint so reset either the left or right pointer for the first time
        if(height[left] < height[right])
        {
         left++;   
        }
        else
        {
         right--;
        }
        while(left < right)
        {
           if((Math.min(height[left], height[right]) * (right - left)) > maxA)
           {
               maxA = Math.min(height[left], height[right]) * (right - left);
           }
            if(height[left] < height[right])
            {
             left++;   
            }
            else
            {
             right--;
            }
           
        }
        return maxA; 
    }
}