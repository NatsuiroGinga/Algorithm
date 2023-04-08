package B;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 15/3/2023 下午2:20
 */
public class BadBoy {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int t, n, m, i, j;

    public static void main(String[] args) {
        t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            i = scanner.nextInt();
            j = scanner.nextInt();
            System.out.printf("1 1 %d %d\n", n, m);
        }
    }
}
