package chapter_3;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 7/4/2023 上午8:25
 */
public class CalculatorConundrum {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static StringBuilder output = new StringBuilder();
    static int t, n, k;

    public static void main(String[] args) {
        t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            k = input.nextInt();
            int ans = k;
            int slow = k, fast = k;

            do {
                slow = nextN(n, slow);
                fast = nextN(n, fast);
                ans = Math.max(ans, fast);
                fast = nextN(n, fast);
                ans = Math.max(ans, fast);
            }
            while (slow != fast);

            output.append(ans);
            output.append('\n');
        }

        System.out.print(output);
        input.close();
    }

    private static int nextN(int n, int k) {
        long pow = (long) k * k;
        final String powStr = String.valueOf(pow);
        return powStr.length() > n ? Integer.parseInt(powStr.substring(0, n)) : Integer.parseInt(powStr);
    }
}
