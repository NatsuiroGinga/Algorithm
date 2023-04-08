package greedy;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 27/3/2023 上午10:43
 */
public class SpreadingTheWealth {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int n;
    static long ans;

    public static void main(String[] args) {
        for (n = input.nextInt();
             !input.hasNext("EOF");
             n = input.nextInt()) {

            long[] coins = new long[n + 1];
            long avg, sum = 0;
            for (int i = 1; i <= n; i++) {
                coins[i] = input.nextLong();
                sum += coins[i];
            }
            avg = sum / n;

            long[] c = new long[n];
            c[0] = 0;
            for (int i = 1; i < n; i++) {
                c[i] = c[i - 1] + coins[i] - avg;
            }

            Arrays.sort(c);
            long mid = c[n / 2];

            for (int i = 0; i < n; i++) {
                ans += Math.abs(mid - c[i]);
            }

            System.out.println(ans);
        }
    }
}
