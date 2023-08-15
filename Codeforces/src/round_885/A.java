package round_885;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 3/8/2023 上午8:29
 */
public class A {

    static Scanner in = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int t, k, x, y, a, b, s;

    public static void main(String[] args) {
        t = in.nextInt();

        while (t-- > 0) {
            a = in.nextInt();
            b = in.nextInt();
            k = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            s = (x + y) % 2;
            boolean ok = false;

            while (k-- > 0) {
                a = in.nextInt();
                b = in.nextInt();
                if ((a + b) % 2 == s) {
                    ok = true;
                }
            }

            out.println(ok ? "NO" : "YES");
        }
    }
}
