package arrays;
public class ProductOfAllExceptSelf{
   public int[] productExceptSelf(int[] nums) {
           //start : 9:16
           //end 9:46
           
           /*
           Given an integer array nums, return an array answer such that answer[i] is equal to           the product of all the elements of nums except nums[i].
           
           BF:
           - nums and ans will be of the same length 
           - for every i multiply all elements not at index i, and store its result (product) at ans[i] but that would take O(n^2) time
           
           - can also get the total product and divid out the number at indeix i and store res in ans[i] would take O(n) but cannot use division operation
           
           2nd method:
           - For every single value in the input array compute its prefix (numbers before it) and postfix (numbers after it) product 
           - store prefix and postfi product in two seperate arrays but that would take O(n) space. 
           - For every single value in the input array, multiply its prefix and postfix product 
           
           2nd method optimized:
           - Same concept except, you initilaize an empty array of same length as nums 
           - Store prefix product in this retArr and multiply it with postfix product for num in nums
               - init first element of retArr to 1 becuz first num has prefix of 1
               - loop from index 1 in retArr, so for the prefix for retArr[1] (2nd element) will be 
               (current_prefix) 1 * nums[i - 1] and so on .. continue doing this as long as i < nums.length 
               - postfix of last value is also 1, so the product of array except the last num in nums will be post * retArr(nums.length - 1), postfix is reset to multiply it with the last element of nums and so on.  You're adding to retArr here and resetting postfix every time as long as i of retArr is >= 0.
           */
           
           int [] retArr = new int[nums.length];
           
           //fill in prefixes of every num in nums ; [3,4] [4,3]
           int prefix = 1;
           //first num has prefix of 1
           retArr[0] = 1;
           for(int i = 1; i < retArr.length; i++)
           {
               prefix *= nums[i - 1]; //
               retArr[i] = prefix;
           }
           
           //calculat postfixes of every num in nums and multiply it with the num's postfix that is already in retArr ; [3,4,5] [1,3, 12]
           int postfix = 1;
           for(int i = retArr.length - 1; i >= 0; i--)
           {
               retArr[i] *= postfix;
               postfix *= nums[i]; // postfix will essentially store the total product at the end but we are not returning the postfix anyway
               
           }
           return retArr;
       }
}