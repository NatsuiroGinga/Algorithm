package B;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 23/3/2023 下午2:13
 */
public class AProsperousLot {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int k;

    public static void main(String[] args) {
        k = scanner.nextInt();

        if (k > 36) {
            System.out.println(-1);
            return;
        }

        while (k >= 2) {
            System.out.print(8);
            k -= 2;
        }

        if (k == 1) {
            System.out.print(4);
        }

        System.out.println();
    }
}
