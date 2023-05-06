import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 12/4/2023 下午7:21
 */
public class P2 {
    private static final Scanner input = new Scanner(new BufferedInputStream(System.in));
    private static final PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));
    private static int n, ans = Integer.MIN_VALUE;
    private static int[] a, prefix;

    public static void main(String[] args) {
        n = input.nextInt();
        a = new int[n + 1];
        prefix = new int[n + 1];
        prefix[0] = 0;
        int sum = 0;
        int f1 = 0, f2 = 0;

        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
            prefix[i] = prefix[i - 1] + a[i];
            sum += a[i];
        }

        System.out.println("sum = " + sum);
        System.out.println("prefix = " + Arrays.toString(prefix));

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (ans < sum - (prefix[j] - prefix[i - 1])) {
                    f1 = i;
                    f2 = j;
                    ans = sum - (prefix[j] - prefix[i - 1]);
                }
            }
        }

        sum = ans;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == f1 && j == f2) continue;
                if (ans < sum - (prefix[j] - prefix[i - 1])) {
                    ans = sum - (prefix[j] - prefix[i - 1]);
                }
            }
        }

        output.println(ans);
        input.close();
        output.close();
    }
}
