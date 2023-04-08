import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 25/3/2023 下午8:01
 */
public class Choco {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int n, m;
    static long[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();

        a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        for (int i = 0; i < m; i++) {
            long q = scanner.nextLong();
            int ans = 0;

            for (int j = 0; j < n; j++) {
                final long pow = a[j] * a[j];
                if (q - pow >= 0) {
                    ans++;
                    q -= pow;
                }
            }

            System.out.print(ans + " ");
        }
    }
}
