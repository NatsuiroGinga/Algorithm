package meituan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 12/8/2023 上午10:52
 */
public class C {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int n, m;
    static long[] rows, cols;

    public static void main(String[] args) {
        n = input.nextInt();
        m = input.nextInt();
        rows = new long[n];
        cols = new long[m];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long tmp = input.nextLong();
                rows[i] += tmp; // 横
                cols[j] += tmp; // 纵
                sum += tmp;
            }
        }

        long ans = Integer.MAX_VALUE;
        long div = 0;

        // 1. 横切
        for (int r = 0; r < n; r++) {
            div += rows[r];
            ans = Math.min(ans, Math.abs(sum - 2 * div));
        }

        div = 0;
        // 2. 竖切
        for (int c = 0; c < m; c++) {
            div += cols[c];
            ans = Math.min(ans, Math.abs(sum - 2 * div));
        }

        output.println(ans);
    }
}
