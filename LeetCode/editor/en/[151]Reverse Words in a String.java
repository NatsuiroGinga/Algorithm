//Given an input string s, reverse the order of the words. 
//
// A word is defined as a sequence of non-space characters. The words in s will 
//be separated by at least one space. 
//
// Return a string of the words in reverse order concatenated by a single space.
// 
//
// Note that s may contain leading or trailing spaces or multiple spaces 
//between two words. The returned string should only have a single space separating the 
//words. Do not include any extra spaces. 
//
// 
// Example 1: 
//
// 
//Input: s = "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing 
//spaces.
// 
//
// Example 3: 
//
// 
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s contains English letters (upper-case and lower-case), digits, and spaces ' 
//'. 
// There is at least one word in s. 
// 
//
// 
// Follow-up: If the string data type is mutable in your language, can you 
//solve it in-place with O(1) extra space? 
//
// Related Topics Two Pointers String 👍 6647 👎 4753


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] arr = removeExtraSpaces(s.toCharArray());
        reverse(arr, 0, arr.length - 1);
        int start = 0;
        for (int i = 0; i <= arr.length; i++) {
            if (i == arr.length || arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }
        }

        return new String(arr);
    }

    private char[] removeExtraSpaces(char[] arr) {
        int slow = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                if (slow != 0) arr[slow++] = ' ';
                while (i < arr.length && arr[i] != ' ') {
                    arr[slow++] = arr[i++];
                }
            }
        }
        return Arrays.copyOf(arr, slow);
    }

    private void reverse(char[] arr, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
