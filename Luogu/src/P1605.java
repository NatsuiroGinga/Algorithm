import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 14/8/2023 上午8:12
 */
public class P1605 {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int n, m, t, ans;
    static int sx, sy, fx, fy;
    static char[][] matrix;
    static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public static void main(String[] args) {
        n = input.nextInt();
        m = input.nextInt();
        matrix = new char[n + 5][m + 5];
        t = input.nextInt();
        sx = input.nextInt();
        sy = input.nextInt();
        fx = input.nextInt();
        fy = input.nextInt();

        for (int i = 1; i <= t; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            matrix[x][y] = 'n'; // 有障碍
        }
        matrix[sx][sy] = 'v'; // 已访问
        output.println(dfs(sx, sy));
    }

    private static int dfs(int r, int c) {
        if (r == fx && c == fy) return 1;

        int path = 0;
        for (int[] pair : dir) {
            int nr = r + pair[0];
            int nc = c + pair[1];

            if (inArea(nr, nc) && matrix[nr][nc] != 'v' && matrix[nr][nc] != 'n') {
                matrix[nr][nc] = 'v';
                path += dfs(nr, nc);
                matrix[nr][nc] = 'y';
            }
        }
        return path;
    }

    private static boolean inArea(int r, int c) {
        return r >= 1 && r <= n && c >= 1 && c <= m;
    }
}
