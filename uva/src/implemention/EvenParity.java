package implemention;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 28/3/2023 上午8:25
 */
public class EvenParity {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int n, t;
    static byte[][] a, b;

    public static void main(String[] args) {
        t = input.nextInt();
        for (int c = 1; c <= t; c++) {
            n = input.nextInt();
            a = new byte[n][n];
            b = new byte[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = input.nextByte();

            int ans = Integer.MAX_VALUE;
            for (int s = 0; s < (1 << n); s++) // 二进制形式枚举第一行的状态
                ans = Math.min(ans, check(s));

            System.out.printf("Case %d: ", c);

            if (ans == Integer.MAX_VALUE)
                System.out.print(-1);
            else
                System.out.print(ans);

            System.out.println();
        }
    }

    private static int check(int s) {
        for (byte[] bytes : b)
            Arrays.fill(bytes, (byte) 0);

        // 初始化b数组的第0行
        for (int c = 0; c < n; c++) { // 枚举第0行的每一列的情况
            if ((s & (1 << c)) > 0) // 第0行的第c列 和 s 的 第c个数 是否都为1
                b[0][c] = 1;
            else if (a[0][c] == 1) // s的第c个数为0, 但是原数组的第0行第c列为1, 而1不能变为0
                return Integer.MAX_VALUE;
        }

        for (int r = 1; r < n; r++) { // 第1行开始
            for (int c = 0; c < n; c++) { // 第0列开始
                byte sum = 0;
                // 检测 b[r-1][c]处的元素的上, 左, 右 之和
                if (r > 1)
                    sum += b[r - 2][c];
                if (c > 0)
                    sum += b[r - 1][c - 1];
                if (c < n - 1)
                    sum += b[r - 1][c + 1];
                // 根据 b[r-1][c]的上, 左, 右的元素之和, 给下元素--即b[r][c]赋值
                b[r][c] = (byte) (sum % 2);

                // 1 不能变为 0
                if (a[r][c] == 1 && b[r][c] == 0)
                    return Integer.MAX_VALUE;
            }
        }

        int cnt = 0;
        // 计数 改变后的数组和原数组有多少位改变了
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                if (b[r][c] != a[r][c])
                    cnt++;

        return cnt;
    }
}
