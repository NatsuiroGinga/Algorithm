package dp;

import java.util.Arrays;

/**
 * @author ginga
 * @since 8/5/2023 下午2:13
 */
public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Arrays.stream(new int[]{ dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1, dp[i][j - 1] + 1 })
                                     .min()
                                     .getAsInt();
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
