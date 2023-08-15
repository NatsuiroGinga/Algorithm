# Leetcode 115. Distinct Subsequences

## 题意

给定两个字符串S和T，求S中有多少个不同的子序列与T相等。

## 题解

动态规划。设`dp[i][j]`为S的前i个字符中有多少个子序列与T的前j个字符相等。则有：

1. `dp[i][0] = 1`，即T为空串时，S的任意子序列都与T相等。
2. `dp[0][j] = 0`，即S为空串时，S的任意子序列都不与T相等。
3. `dp[i][j] = dp[i-1][j] + (S[i] == T[j] ? dp[i-1][j-1] : 0)`
   ，即S的前i个字符中有多少个子序列与T的前j个字符相等，等于S的前i-1个字符中有多少个子序列与T的前j个字符相等，加上S的前i-1个字符中有多少个子序列与T的前j-1个字符相等（如果S[i] ==
   T[j]）。
4. 最终答案为`dp[S.length()][T.length()]`。

## 代码

```java

class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}

```