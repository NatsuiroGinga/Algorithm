package greedy;

import java.util.Arrays;

/**
 * @author ginga
 * @since 6/5/2023 上午10:49
 */
public class LeetCode738 {
    public static void main(String[] args) {
        LeetCode738 leetCode738 = new LeetCode738();
        int i = leetCode738.monotoneIncreasingDigits(10);
        System.out.println(i);
    }

    public int monotoneIncreasingDigits(int n) {
        String num = Integer.toString(n);
        char[] arr = num.toCharArray();
        int flag = arr.length;

        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i - 1] > arr[i]) {
                arr[i - 1]--;
                flag = i;
            }
        }

        Arrays.fill(arr, flag, arr.length, '9');

        return Integer.parseInt(new String(arr));
    }
}
