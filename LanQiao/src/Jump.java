import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href="https://www.lanqiao.cn/problems/553/learning/?page=2&first_category_id=1&sort=students_count&category_id=3">
 * 跳跃
 * </a>
 *
 * @author ginga
 * @since 5/3/2023 下午4:57
 */
public class Jump {

    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int n = input.nextInt();
    static int m = input.nextInt();
    static int[][] map = new int[n][m];
    static int[] dx = { 0, 0, 0, 1, 2, 3, 1, 2, 1 };
    static int[] dy = { 1, 2, 3, 0, 0, 0, 1, 1, 2 };
    static int maxLen = Integer.MIN_VALUE;

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = input.nextInt();
            }
        }
        dfs(0, 0, map[0][0]);
        System.out.println(maxLen);
    }

    private static void dfs(int i, int j, int length) {
        if (i == n - 1 && j == m - 1) {
            maxLen = Math.max(maxLen, length);
            return;
        }
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < n && y >= 0 && y < m) {
                dfs(x, y, length + map[x][y]);
            }
        }
    }
}
