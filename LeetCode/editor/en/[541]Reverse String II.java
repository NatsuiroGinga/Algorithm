//Given a string s and an integer k, reverse the first k characters for every 2
//k characters counting from the start of the string. 
//
// If there are fewer than k characters left, reverse all of them. If there are 
//less than 2k but greater than or equal to k characters, then reverse the first 
//k characters and leave the other as original. 
//
// 
// Example 1: 
// Input: s = "abcdefg", k = 2
//Output: "bacdfeg"
// 
// Example 2: 
// Input: s = "abcd", k = 2
//Output: "bacd"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of only lowercase English letters. 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics Two Pointers String 👍 1678 👎 3317


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i += 2 * k) {
            if (i + k - 1 < arr.length) {
                reverse(arr, i, i + k - 1);
                continue;
            }
            reverse(arr, i, arr.length - 1);
        }

        return new String(arr);
    }

    private void reverse(char[] s, int low, int high) {
        for (; low < high; low++, high--) {
            char t = s[low];
            s[low] = s[high];
            s[high] = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
