package org.example.strings;

import java.util.ArrayList;
import java.util.List;

public class FindGreaterPermut {

    public String permute(String word, List<String> permutation, boolean [] visited, String [] letters)
    {
        String res = "no answer";

        if(permutation.size() == letters.length)
        {
            // return the next alpha greater permutation immediately
            if(String.join("", permutation).compareTo(word) > 0)
            {
                res = String.join("", permutation);
                return res;
            }
        }
        // loop through all the letters adding and removing same letter at a time
        // If the above if stmt was true, each letter has been visisted, so I will not call permute anymore and return 'no answer' straight
        for(int i = 0; i < letters.length; i++)
        {
            if(!visited[i])
            {
                permutation.add(letters[i]);
                visited[i] = true;
                res = permute(word, permutation, visited, letters);
                // if u found the next greater one no need to generate more permutations
                if(!(res.equals("no answer")))
                {
                    return res;
                }
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }

        return res;
    }
    public String rearrangeWord(String word)
    {
        /* Call a permute method here that returns the next alphabetically greater permutation of word
        * If u don't find any return 'no answer' as a string
        * Things to keep in mind:
        * Need to keep track of word
        * Convert word to an array of chars and pass it in permute method
        * The permute method will return the next alphabetically greater string or 'no answer'
        * */
        String [] letters = word.split("");
        boolean [] visited = new boolean[letters.length];
        return permute(word, new ArrayList<>(), visited, letters);
    }
}
