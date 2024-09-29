package dynamicprog;

import java.util.Arrays;

public class FindLCS {
    public String longestCommonPrefix(String[] strs) {
        for(int i = 1; i < strs.length; i++)
        {
            findLCS(strs, strs[0], strs[i]);
        }
        return strs[0];

    }

    public void findLCS(String [] strs, String word1, String word2)
    {
        String [][] dp = new String[word1.length() + 1][word2.length() + 1];

        // TODO: Note
        Arrays.fill(dp[dp.length - 1], "");

        for(int i = 0; i < dp.length; i++)
        {
            dp[i][dp[0].length - 1] = "";
        }

        for(int r = dp.length - 2; r >= 0; r--)
        {
            for(int c = dp[0].length - 2; c >= 0; c--)
            {
                if(word1.charAt(r) == word2.charAt(c))
                {
                    dp[r][c] = word1.substring(r, r + 1) + dp[r + 1][c + 1];
                }
                else
                {
                    if(dp[r][c + 1].length() > dp[r + 1][c].length())
                    {
                        dp[r][c] = dp[r][c + 1];
                    }
                    else
                    {
                        dp[r][c] = dp[r + 1][c];
                    }
                }
            }
        }

        strs[0] = dp[0][0];
    }
}

