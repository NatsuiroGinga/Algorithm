package edu_round_151;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 5/8/2023 上午8:36
 */
public class B {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int xa, ya, xb, yb, xc, yc;

    public static void main(String[] args) {
        int t = input.nextInt();
        while (t-- > 0) solve();
    }

    private static void solve() {
        xa = input.nextInt();
        ya = input.nextInt();
        xb = input.nextInt();
        yb = input.nextInt();
        xc = input.nextInt();
        yc = input.nextInt();

        xb -= xa;
        xc -= xa;
        yb -= ya;
        yc -= ya;

        int ans = 1;
        if ((xb > 0) == (xc > 0)) {
            ans += Math.min(Math.abs(xb), Math.abs(xc));
        }
        if ((yb > 0) == (yc > 0)) {
            ans += Math.min(Math.abs(yb), Math.abs(yc));
        }

        output.println(ans);
    }
}
