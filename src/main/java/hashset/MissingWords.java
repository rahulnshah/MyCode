package hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingWords {
    public List<String> missingWords(String s, String t)
    {
        /*
        Assume t is a subseq. of s, so find words of s missing in (not in) t
        store all words in t in a set
        Loop over s, if word not in t, add it to empty list
         */
        List<String> missingWords = new ArrayList<>();
        String [] wordsOfS = s.split(" ");
        String [] wordsOfT = t.split(" ");
        Set<String> tWords = new HashSet<>();
        for(String word : wordsOfT)
        {
            tWords.add(word);
        }
        for(String word : wordsOfS)
        {
         if(!tWords.contains(word))
         {
             missingWords.add(word);
         }
        }
        return missingWords;

    }
}
