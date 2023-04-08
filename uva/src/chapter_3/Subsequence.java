package chapter_3;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 7/4/2023 上午8:53
 */
public class Subsequence {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static StringBuilder output = new StringBuilder();
    static int n, s;
    static int[] arr;

    public static void main(String[] args) {
        do {
            n = input.nextInt();

            if (n == -1) break;

            s = input.nextInt();
            arr = new int[n + 1];
            int ans = n + 1;
            int[] prefix = new int[n + 1];
            prefix[0] = 0;

            for (int i = 1; i <= n; i++) {
                arr[i] = input.nextInt();
                prefix[i] = prefix[i - 1] + arr[i];
            }

            //  5 1 3  5 10  7  4   9  2  8
            //0 5 6 9 14 24 31  35 44  46 54
            for (int j = 1; j <= n; j++) {
                int i = Arrays.binarySearch(prefix, 0, j, prefix[j] - s);
                if (i > 0) {
                    ans = Math.min(ans, j - i);
                } else if (i != -1) {
                    int x = -i - 1;
                    ans = Math.min(ans, j - x + 1);
                }
            }

            output.append(ans == n + 1 ? 0 : ans).append('\n');

        } while (true);

        System.out.print(output);
        input.close();
    }
}
