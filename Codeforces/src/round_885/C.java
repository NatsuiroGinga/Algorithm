package round_885;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 3/8/2023 上午10:01
 */
public class C {
    static Scanner in = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int t, n;

    static int[] a = new int[100005];
    static int[] b = new int[100005];

    public static void main(String[] args) {
        t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        n = in.nextInt();
        int ert = 0;

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            ert |= calc(a[i], b[i]); // 或运算压缩空间
        }
        out.println(Integer.bitCount(ert) <= 1 ? "YES" : "NO");
    }

    private static int calc(int x, int y) {
        if (x == 0 && y == 0) return 0; // 0
        int s = gcd(x, y);
        x /= s;
        y /= s;
        if ((x & 1) == 0) return 1; // 01
        if ((y & 1) == 0) return 2; // 10
        return 4; // 100
    }

    private static int gcd(int p, int q) {
        return q == 0 ? p : gcd(q, p % q);
    }
}
