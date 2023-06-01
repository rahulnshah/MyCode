package arrays;
public class ValidAnagram
{
   /*
   Given two strings s and t, return true if t is an anagram of s, and false otherwise.
   
   An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
   typically using all the original letters exactly once.
   */
   public boolean isAnagram(String s, String t) {
      /*
      BF: Make two hashmaps, one for s and one for t, fill both maps up, and return sMap.equals(tMap);
      2nd method:
      - if len(s) == len(t):
         - Create an array of 26 ints (0 to 25)
         - loop s and increment the value of the element associated with every letter of s
         - loop t and decrement the value of the element associated with every letter of t
         - loop the array of 26 ints and if any one of its elements != 0, return false else return true 
      */
      if(s.length() != t.length())
      {
         return false;
      }
      // s and t are of same length
      int [] letterInts = new int[26];
      for(int i = 0; i < s.length(); i++)
      {
         letterInts[s.charAt(i) - 'a']++;
         letterInts[t.charAt(i) - 'a']--;
      }
      
      for(int i : letterInts)
      {
         if(i != 0){
            return false;
         }
      }
      return true;
   }
}