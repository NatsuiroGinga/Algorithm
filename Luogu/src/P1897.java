import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1897">
 * P1897 电梯里的爱情
 * </a>
 *
 * @author ginga
 * @since 5/3/2023 下午10:01
 */
public class P1897 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int[] arr = new int[n + 5];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int front = 0, count = 0;
        // (2 * 6 + 5 + 1 + 1) + (6 + 5 + 1) + (6 + 5 + 1) + 4 * 4 =
        // 19 + 12 + 12 + 16 = 59

        for (int v : arr) {
            if (v == front)
                count++;
        }
    }
}
