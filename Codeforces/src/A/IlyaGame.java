package A;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 8/3/2023 下午2:15
 */
public class IlyaGame {

    static boolean flag;

    static int[][] dx = {
            { -1, -2 }, // 上两行
            { 1, 2 }, // 下两行
            { 0, 0 }, // 左两列
            { 0, 0 }, // 右两列
            { -1, -2 }, // 左上两个
            { 1, 2 }, // 左下两个
            { -1, -2 }, // 右上两个
            { 1, 2 } // 右下两个
    };
    static int[][] dy = {
            { 0, 0 }, // 上两行
            { 0, 0 }, // 下两行
            { -1, -2 }, // 左两列
            { 1, 2 }, // 右两列
            { -1, -2 }, // 左上两个
            { -1, -2 }, // 左下两个
            { 1, 2 }, // 右上两个
            { 1, 2 } // 右下两个
    };

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        final char[][] chessboard = new char[4][4];

        for (int i = 0; i < 4; i++) {
            chessboard[i] = scanner.next().toCharArray();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (chessboard[i][j] == '.') {
                    chessboard[i][j] = 'x';
                    dfs(chessboard);
                    if (flag) {
                        System.out.print("YES");
                        return;
                    }
                    chessboard[i][j] = '.';
                }
            }
        }

        System.out.print(flag ? "YES" : "NO");
    }

    private static void dfs(char[][] chessboard) {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (chessboard[i][j] == 'x')
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k][0];
                        int y = j + dy[k][0];
                        int x1 = i + dx[k][1];
                        int y1 = j + dy[k][1];

                        if (isIllegal(x, y) && isIllegal(x1, y1) && chessboard[x][y] == 'x' && chessboard[x1][y1] == 'x') {
                            flag = true;
                            return;
                        }
                    }

    }

    private static boolean isIllegal(int i, int j) {
        return i >= 0 && i < 4 && j >= 0 && j < 4;
    }

}
