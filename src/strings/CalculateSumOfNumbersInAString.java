package strings;
public class CalculateSumOfNumbersInAString
{
   public int Solution(String s)
   {
      /*
      Given inputstring s, made up of English letters and digits from 0-9, calculate the sum of only numbers init 
      The sequeunce of consuectuove digits is considered one number 
      "0ab789b5"
      Time: O(n)
      
      BF:
      -slding window: init left and right pointers both to index 0  
      */
      int left = 0;
      int right = 0;
      int sum = 0;
      while(right < s.length())
      {
         if(s.charAt(left) >= '0' && s.charAt(left) <= '9')
         {
            String toAdd = "";
            toAdd += s.charAt(left);
            right++;
            while(right < s.length() && (s.charAt(right) >= '0' && s.charAt(right) <= '9'))
            {
               toAdd += s.charAt(right);
               right++;
            }
            sum += Integer.parseInt(toAdd);
            left = right;
         }
         else 
         {
            left++;
            right++;
         }
      }
      return sum;
   }


}