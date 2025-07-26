package org.example.strings;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        /*
        Approach: 2-ptr problem;
        Set a left ptr on s and t.
        Move s's left ptr to the right if s[i] == s[j]
        Always move t's ptr to the right, becasue we're trying to check if
        s is a subseq. of t, not the other way around.

        if we're at the end of s we return true else we are at the end of t so we return false.
        */

        int sL = 0, tL = 0;
        while(sL < s.length() && tL < t.length())
        {
            if(s.charAt(sL) == t.charAt(tL))
            {
                sL++;
            }
            tL++;
        }

        return sL >= s.length();
    }
}
