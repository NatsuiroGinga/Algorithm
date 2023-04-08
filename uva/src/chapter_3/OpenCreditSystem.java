package chapter_3;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 28/3/2023 下午2:23
 */
public class OpenCreditSystem {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int t, n;
    static int[] arr;

    public static void main(String[] args) {
        t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = input.nextInt();

            int maxAi = arr[0]; // 预设 最大的 a[i] 为 a[0]
            int ans = arr[0] - arr[1]; // 预设 答案为 a[0] - a[1]

            for (int j = 1; j < n; j++) { // 对于每一个a[j], 寻找 i < j, 且 a[i] 最大的数
                ans = Math.max(ans, maxAi - arr[j]);
                maxAi = Math.max(maxAi, arr[j]);
            }

            System.out.println(ans);
        }
    }
}
