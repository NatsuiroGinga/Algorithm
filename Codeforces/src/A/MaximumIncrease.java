package A;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 13/3/2023 下午7:57
 */
public class MaximumIncrease {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        int maxLen = 1;
        int cur = 1;
        n = scanner.nextInt();
        arr = new int[n + 5];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) cur++;
            else {
                maxLen = Math.max(maxLen, cur);
                cur = 1;
            }
        }

        System.out.println(Math.max(maxLen, cur));
    }
}
