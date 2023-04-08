package B;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 17/3/2023 上午11:07
 */
public class Vitamins {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int n;
    static int[] dp = new int[8];
    static int[] vitamins, prices;

    public static void main(String[] args) {
        n = scanner.nextInt();
        prices = new int[n + 5];
        vitamins = new int[n + 5];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            prices[i] = scanner.nextInt();

            for (char c : scanner.next().toCharArray()) {
                switch (c) {
                    case 'A':
                        vitamins[i] |= 1;
                        break;
                    case 'B':
                        vitamins[i] |= 2;
                        break;
                    case 'C':
                        vitamins[i] |= 4;
                        break;
                }
            }
        }

        for (int i = 1; i <= n; i++)
//            for (int j = 7; j >= 0; j--)
            for (int j = 0; j <= 7; j++) {
                dp[j | vitamins[i]] = Math.min(dp[j | vitamins[i]], dp[j] + prices[i]);
                System.out.println(Arrays.toString(dp));
            }

        System.out.println(dp[7] == 0x3f3f3f3f ? -1 : dp[7]);
    }
}
