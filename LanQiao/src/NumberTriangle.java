import java.util.Scanner;

/**
 * <a href="https://www.lanqiao.cn/problems/505/learning/?page=1&first_category_id=1&sort=students_count&category_id=3">
 * 数字三角形
 * </a>
 *
 * @author ginga
 * @since 1/3/2023 上午8:35
 */
public class NumberTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] triangle = new int[n + 5][n + 5];
        int[][] arr = new int[n + 5][n + 5];

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = scan.nextInt();
            }
        }

        arr[1][1] = triangle[1][1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) arr[i][j] = triangle[i][j] + arr[i - 1][j];
                else if (i == j) arr[i][j] = triangle[i][j] + arr[i - 1][j - 1];
                else arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - 1]) + triangle[i][j];
            }
        }

        if (n % 2 == 1) System.out.println(arr[n][n / 2 + 1]);
        else System.out.println(Math.max(arr[n][n / 2], arr[n][n / 2 + 1]));

        scan.close();
    }
}
