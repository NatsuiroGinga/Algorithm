package A;

import java.util.Scanner;

/**
 * @author ginga
 * @since 7/3/2023 下午4:20
 */
public class TriangularNumbers {

    private static boolean f(int i, int n) {
        return i * (i + 1) == n * 2;
    }

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            if (f(i, n)) {
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");
    }
}
