package strings;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        int len = 0;

        // loop s, and start exp left and right ptr outward from each pos i
        // and check for palindromes
        for(int i = 0; i < s.length(); i++)
        {
            // odd length palindromes
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                if(((r - l) + 1) > len)
                {
                    len = ((r - l) + 1);
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            // even palindromes
            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                if(((r - l) + 1) > len)
                {
                    len = ((r - l) + 1);
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }

        return res;
    }
}
