package hashmap;

import java.util.*;

public class GroupAnagrams{
   public List<List<String>> groupAnagrams(String[] strs) {
        // end : 6: 20 
        //actual : 6: 34
        
        /*
        BF: can take every combo in strs and check if they are anagrams and create an list in every iteration 
        but that would take O(n^3) time because isAnagrams takes O(n)
        
        2nd method:
           - Create a hashmap mapping hashmaps to an arraylist of strings 
           - Loop strs and for each str create a letter freq. map
           - if the above hashmap is not found in the bigger map, add it and set its value to that string first in the list 
           - if the above map is found, then add the str to the list assoc. with that hashmap
           - all keys (maps) are unique in the bigger map, so gather all the values (lists) and add each list inside another list 
           - return the bigger list 
        
        Time: O(m*n) , where m is the number of str in strs and n is each character of str (approx.)
        Space: O(m*n), where m is the number of str in strs and n is each character of str (approx.)
        */
        List<List<String>> groupOfAnagrams = new ArrayList<List<String>>();
        Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();
        for(String str : strs){
            // create freq dict {"c" : 1, ...}
            Map<Character, Integer> mp = new HashMap<>();
            for(int i = 0; i < str.length(); i++)
            {
                if(!mp.containsKey(str.charAt(i)))
                {
                   mp.put(str.charAt(i), 0); 
                }
                mp.put(str.charAt(i), mp.get(str.charAt(i)) + 1);
            } 
            if(!groups.containsKey(mp))
            {
                List<String> gofStrings = new ArrayList<String>();
                gofStrings.add(str);
                groups.put(mp, gofStrings);
            }
            else // it does contain a similar dict 
            {
                
              List<String> gofStrings = groups.get(mp);
              gofStrings.add(str);
              groups.put(mp, gofStrings);  
            }
        }
        for(Map<Character, Integer> mp : groups.keySet())
        {
            groupOfAnagrams.add(groups.get(mp));
        }
        return groupOfAnagrams;   
    }
}