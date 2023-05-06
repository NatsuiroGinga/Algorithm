package hash;

/**
 * @author ginga
 * @since 27/4/2023 上午9:19
 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }
        for (char c : t.toCharArray()) {
            if (freq[c] > 0) freq[c]--;
            else return false;
        }
        for (int f : freq) {
            if (f != 0) return false;
        }

        return true;
    }
}
