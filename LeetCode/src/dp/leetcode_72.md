# LeetCode 72. Edit Distance——medium

## Problem description:

> Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
> You have the following 3 operations permitted on a word:
> 1. Insert a character
> 2. Delete a character
> 3. Replace a character

## 翻译

> 给定两个单词 word1 和 word2，找到将 word1 转换为 word2 所需的最小操作数。
> 你可以对一个单词进行以下 3 种操作：
> 1. 插入一个字符
> 2. 删除一个字符
> 3. 替换一个字符

## 示例

> Input: word1 = "horse", word2 = "ros"
> Output: 3
> Explanation:
> horse -> rorse (replace 'h' with 'r')
> rorse -> rose (remove 'r')
> rose -> ros (remove 'e')

## 思路

### 递归

> 递归的思路是，如果 word1 和 word2
> 的最后一个字符相同，那么就不需要操作，直接去掉最后一个字符，然后递归求解即可。如果最后一个字符不同，那么就有三种操作方式，分别是替换、删除和插入，我们分别递归求解三种情况下的最小操作数，然后取三者的最小值即可。
> 递归的终止条件是，如果 word1 和 word2 中有一个为空，那么返回另一个字符串的长度，因为我们可以直接将另一个字符串插入到空字符串中。如果
> word1 和 word2 都为空，那么返回 0。
> 递归的时间复杂度是 O(3^m)，其中 m 是 word1 的长度。因为每次递归都会减少一个字符，所以递归的层数最多是 word1 的长度，每层递归有
> 3 种情况，所以时间复杂度是 O(3^m)。空间复杂度是 O(m)，即为递归的栈空间。

### 代码

```java
public class Solution {
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int helper(String word1, String word2, int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return helper(word1, word2, i - 1, j - 1);
        } else {
            return Math.min(helper(word1, word2, i - 1, j - 1) + 1,
                            Math.min(helper(word1, word2, i - 1, j) + 1, helper(word1, word2, i, j - 1) + 1));
        }
    }
}
```

### 动态规划

1. 状态定义：dp[i][j] 表示 word1 的前 i 个字符转换成 word2 的前 j 个字符所需要的最小操作数。
2. 状态转移方程：如果 word1[i] == word2[j]，那么 dp[i][j] = dp[i - 1][j - 1]，如果 word1[i] != word2[j]，那么 dp[i][j] =
   min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1。
3. 初始状态：dp[0][j] = j，dp[i][0] = i。
4. 返回值：dp[word1.length()][word2.length()]。

```java
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
```