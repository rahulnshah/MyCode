package org.example.strings;

import java.util.ArrayList;
import java.util.List;

public class FindEvenAndLongest {
    /* Find the first word that is even length and
    longer than every other even length word */
    public String findEvenLong(String words)
    {

        String [] alsoWords = words.split(" ");
        // find all even length words first and store them in a List
        List<String> evens = new ArrayList<>();

        for(String word : alsoWords)
        {
           if(word.length()%2 == 0)
           {
               evens.add(word);
           }
        }

        int maxLen = evens.get(0).length();
        String longest = evens.get(0);
        for(String word : evens)
        {
            if(word.length() > maxLen)
            {
                longest = word;
            }
        }

        return longest;
    }
}
