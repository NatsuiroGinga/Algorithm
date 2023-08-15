import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 14/8/2023 上午9:44
 */
public class P1040 {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int n;
    static long ans;
    static long[] score;
    static long[][] dp;
    static int[][] root;

    public static void main(String[] args) {
        n = input.nextInt();
        score = new long[n + 5];
        dp = new long[n + 5][n + 5];
        root = new int[n + 5][n + 5];

        for (int i = 1; i <= n; i++) {
            score[i] = input.nextLong();
            dp[i][i] = score[i];
            root[i][i] = i;
        }

        output.println(dfs(1, n));
        preorder(1, n);
        output.println();
    }

    private static long dfs(int left, int right) {
        if (left > right) return 1;
        if (left == right) return score[left];
        if (dp[left][right] != 0) return dp[left][right];

        for (int i = left; i <= right; i++) {
            long leftMax = dfs(left, i - 1);
            long rightMax = dfs(i + 1, right);
            long rootMax = leftMax * rightMax + score[i];
            if (rootMax > dp[left][right]) {
                root[left][right] = i;
                dp[left][right] = rootMax;
            }
        }

        return dp[left][right];
    }

    private static void preorder(int left, int right) {
        if (left > right) return;
        int cur = root[left][right];
        output.print(cur + " ");
        preorder(left, cur - 1);
        preorder(cur + 1, right);
    }

}
