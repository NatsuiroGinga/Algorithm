package C;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 23/3/2023 下午3:45
 */
public class GregAndFriends {
    static Scanner in = new Scanner(new BufferedInputStream(System.in));
    static int k, n;
    static int[] weights, dp;

    public static void main(String[] args) {
        n = in.nextInt();
        k = in.nextInt();
        weights = new int[n + 5];
        dp = new int[k + 5];

        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
        }

    }
}
