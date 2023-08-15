package meituan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 12/8/2023 上午11:16
 */
public class D {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int n;
    static String s;
    static boolean[] vis;
    static int rb, cb;
    static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public static void main(String[] args) {
        n = input.nextInt();
        s = input.next();
        vis = new boolean[n];
        int ans = Integer.MAX_VALUE;

        for (int r = 1; r <= n; r++) {
            if (n % r != 0) continue;
            rb = r;
            cb = n / r; // 列数
            int cur = 0;
            Arrays.fill(vis, false);

            for (int i = 0; i < rb; i++) {
                for (int j = 0; j < cb; j++) {
                    if (!vis[i * j + j]) {
                        cur++;
                        dfs(i, j);
                    }
                }
            }

            if (cur != 0) {
                System.out.println("cur = " + cur);
                ans = Math.min(ans, cur);
            }
        }

        output.println(ans);
    }

    private static void dfs(int row, int col) {
        int index = row * col + col;
        System.out.println("row = " + row + ", col = " + col);
        if (index < 0 || index >= s.length() || vis[index]) return;
        vis[index] = true;
        for (int[] ints : dir) {
            dfs(row + ints[0], col + ints[1]);
        }
    }
}
