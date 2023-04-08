package A;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 12/3/2023 下午3:31
 */
public class CutRibbon {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int n;
    static int[] w = new int[4];
    static int[] f;

    public static void main(String[] args) {
        n = scanner.nextInt();
        f = new int[n + 5];
        Arrays.fill(f, -1);
        f[0] = 0;

        for (int i = 1; i <= 3; i++) {
            w[i] = scanner.nextInt();
        }

        for (int i = 1; i <= 3; i++) {
            for (int j = w[i]; j <= n; j++) {
                if (f[j - w[i]] != -1) {
                    f[j] = Math.max(f[j], f[j - w[i]] + 1);
                }
            }
        }

        System.out.println(f[n]);
    }
}
