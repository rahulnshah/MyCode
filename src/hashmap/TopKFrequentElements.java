package hashmap;
import java.util.*;
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        
        Optimize this: Create a map of num -> freq. and an ArrayList of ArrayLists with its indeics being 
        the number of times a num occurs (len(nums) + 1). Get rid of Arrays.sort 
        
        Given an integer array nums and an integer k, return the k most frequent elements. 
        You may return the answer in any order
        
        I usually create a freq. table for checking freq. 
        
        BF:
        - Create a map of freq -> List of number that occurs that many times
        - Since there is k freq elems, I need to return an array of length k
        - Create a freq table: fill in keys from 1 to nums.length with empty Lists for now becuase one number in nums can occur from 1 to nums.length times 
        - sort nums and collect freq of each unique num in nums; fill in map from step 1
        - get the keySet of map, sort it in descending order, loop it, and then fill in retArr that is of length k while k is > 0.  
            - sort the keySet in descending order because we're looking for TOP k freq. elements.  Largest key is the most amount of times a num can occur 
        - return retArr
        
        Time: O(nlogn) because of Arrays.sort
        Space: O(n)
        */
        int [] retArr = new int[k];
        Map<Integer,Integer> numsToFreq = new HashMap<>();
        ArrayList<List<Integer>> freqToListNums = new ArrayList<List<Integer>>();
        for(int i = 0; i <= nums.length; i++)
        {
         freqToListNums.add(new ArrayList<Integer>());      
        }
        
        //fill up Map
        for(int num : nums)
        {
         if(!numsToFreq.containsKey(num))
         {
            //put 0 for now as its value 
            numsToFreq.put(num, 0);
         }
         // add one to its value 
         numsToFreq.put(num, numsToFreq.get(num) + 1);
        }
        
        // loop map keys (nums) and fill up ArrayList of ArrayLists with nums that occur index times 
        for(Integer num : numsToFreq.keySet())
        {
         freqToListNums.get(numsToFreq.get(num)).add(num);
        }
        
        int retArrIdx = 0;
        
        for(int numTimesOccur = nums.length; numTimesOccur >= 0; numTimesOccur--){
            // get the list associated with that key and loop it 
            List<Integer> allNumsWithKeyFreq = freqToListNums.get(numTimesOccur);
            for(int i = 0; i < allNumsWithKeyFreq.size() && k > 0; i++){
                retArr[retArrIdx] = allNumsWithKeyFreq.get(i); 
                retArrIdx++;
                k--;
            }
        }
        return retArr;
    }
}