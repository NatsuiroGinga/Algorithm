package edu_round_151;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 5/8/2023 上午9:15
 */
public class C {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int t, m;
    static String s, l, r;

    public static void main(String[] args) {
        t = input.nextInt();
        while (t-- > 0) solve();
    }

    private static void solve() {
        s = input.next();
        m = input.nextInt();
        l = input.next();
        r = input.next();
        int n = s.length();
        int[][] next = new int[n + 1][10];
        Arrays.fill(next[n], n);

        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(next[i + 1], 0, next[i], 0, 10);
            next[i][s.charAt(i) - '0'] = i;
        }

        int cur = -1;
        for (int i = 0; i < m && cur < n; i++) {
            int nxt = 0;
            for (int j = l.charAt(i) - '0'; j <= r.charAt(i) - '0'; j++) {
                nxt = Math.max(nxt, next[cur + 1][j]);
            }
            cur = nxt;
        }

        output.println(cur == n ? "YES" : "NO");
    }
}
