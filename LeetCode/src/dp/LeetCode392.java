package dp;

/**
 * @author ginga
 * @since 8/5/2023 上午9:11
 */
public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int j = 0;

        for (int i = 0; i < s2.length && j < s1.length; i++)
            if (s1[i] == s2[j]) j++;


        return j == s.length();
    }
}
