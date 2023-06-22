package hashmap;
import java.util.*;
public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        /*
        2nd Method:
        Make a hashmap of the letters of the word "balloon", with value being the freq of each letter in "balloon"
        Make one more hashmap with the actual freq of the letters in "balloon" in text.
        Then you want to loop the hashmap u made in step 2, check if the letter is in the hashmap for the word "balloon", then take the min of current count (which will start of as MAX_VALUE) and # of letter in text/# letter per "ballon".  I want to take min of the ratio, becuase if I have one b in text and 10 of each other letter in text, I can only make 1 instance of "balloon" from text no matter how hard I try.

        Time : O(n), where n is length of text
        Space: O(n) (cuz I make two hashmaps)
        */
        int count = Integer.MAX_VALUE;

        String word = "balloon";

        Map<Character, Integer> freqOfWord = new HashMap<>();

        for(char c : word.toCharArray())
        {
            freqOfWord.put(c, freqOfWord.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> actualFreq = new HashMap<>();

        for(char c : text.toCharArray())
        {
            actualFreq.put(c, actualFreq.getOrDefault(c, 0) + 1);
        }

        /* store the ratios inside the map for the word "balloon"
            if a a letter from word is not in text, I can't make any instance of it from text so I put 0 for that letter
            if a letter freq does not divde perfectly by the req. letter freq, integer div will take care of that
        */
        for(char c : freqOfWord.keySet())
        {
            if(actualFreq.containsKey(c))
            {
                freqOfWord.put(c, actualFreq.get(c) / freqOfWord.get(c));
            }
            else
            {
                freqOfWord.put(c, 0);
            }
        }

        // find the min number of balloons by looping one more time
        for(char c : freqOfWord.keySet())
        {
            count = Math.min(count, freqOfWord.get(c));
        }

        return count;

    }
}
