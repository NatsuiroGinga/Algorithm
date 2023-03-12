package A;

import java.util.Scanner;

/**
 * @author ginga
 * @since 8/3/2023 下午2:02
 */
public class BuyShovel {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int r = scanner.nextInt();

        int count = 0;

        do {
            count++;
        } while (count * k % 10 != 0 && count * k % 10 != r);

        System.out.println(count);
    }
}
