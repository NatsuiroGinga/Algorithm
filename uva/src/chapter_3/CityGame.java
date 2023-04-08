package chapter_3;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 7/4/2023 上午10:38
 */
public class CityGame {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int t, m, n;
    static int[][] matrix, up, left, right;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            m = input.nextInt();

            matrix = new int[n][m];
            left = new int[n][m];
            right = new int[n][m];
            up = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = input.next().charAt(0) == 'F' ? 0 : 1;
                }
            }

            int ans = 0;
            for (int i = 0; i < n; i++) { // 从上到下
                int leftBound = -1, rightBound = m;

                for (int j = 0; j < m; j++) { // 从左向右扫描
                    if (matrix[i][j] == 1) {
                        up[i][j] = left[i][j] = 0;
                        leftBound = j;
                    } else {
                        up[i][j] = i == 0 ? 1 : up[i - 1][j] + 1;
                        left[i][j] = i == 0 ? leftBound + 1 : Math.max(leftBound + 1, left[i - 1][j]);
                    }
                }

                for (int j = m - 1; j >= 0; j--) {
                    if (matrix[i][j] == 1) {
                        right[i][j] = m;
                        rightBound = j;
                    } else {
                        right[i][j] = i == 0 ? rightBound - 1 : Math.min(rightBound - 1, right[i - 1][j]);
                        ans = Math.max(ans, up[i][j] * (right[i][j] - left[i][j] + 1));
                    }
                }
            }

            output.append(ans * 3).append('\n');
        }

        System.out.print(output);
    }
}
