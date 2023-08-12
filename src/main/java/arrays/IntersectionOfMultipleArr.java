package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfMultipleArr {
        public void findIntersectionOf(int [][] nums, int [] arr1, int [] arr2)
        {
            // Store all nums from arr1 into a set
            Set<Integer> a1 = new HashSet<>();

            for(int num : arr1)
            {
                a1.add(num);
            }

            Set<Integer> intersection = new HashSet<>();

            for(int num : arr2)
            {
                if(a1.contains(num))
                {
                    intersection.add(num);
                }
            }

            int [] result = new int[intersection.size()];

            int i = 0;

            for(Integer num : intersection)
            {
                result[i] = num;
                i++;
            }

            nums[0] = result;
        }
        public List<Integer> intersection(int[][] nums) {
            for(int i = 1; i < nums.length; i++)
            {
                findIntersectionOf(nums, nums[0], nums[i]);
            }

            // nums[0] will hold the intersection so loop it and store values into a returning List
            List<Integer> result = new ArrayList<>();

            for(int num : nums[0])
            {
                result.add(num);
            }

            return result;
        }
}
