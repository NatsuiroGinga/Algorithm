package meituan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 12/8/2023 上午10:14
 */
public class B {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int n, x, y;
    static long[] d;

    public static void main(String[] args) {
        n = input.nextInt();
        d = new long[n + 1];

        for (int i = 0; i < n; i++) {
            d[i] = input.nextInt();
        }

        x = input.nextInt() - 1;
        y = input.nextInt() - 1;

        output.println(solve());
    }

    private static long solve() {
        if (x == y) return 0;
        int start = Math.min(x, y);
        int end = Math.max(x, y);
        long ans1 = 0;
        long ans2 = 0;

        for (int i = start; i < end; i++) {
            ans1 += d[i];
        }
        while (end != start) {
            ans2 += d[end];
            end = (end + 1) % n;
        }

        return Math.min(ans1, ans2);
    }
}
/*
 * 1 2 2 1 1
 *
 * 4 1
 * */
