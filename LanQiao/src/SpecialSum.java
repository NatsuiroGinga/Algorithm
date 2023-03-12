import java.util.Scanner;

/**
 * @author ginga
 * @since 10/3/2023 上午10:39
 */
public class SpecialSum {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (f(i)) sum += i;
        }

        System.out.println(sum);
    }

    private static boolean f(int num) {
        final String s = String.valueOf(num);
        return s.contains("2") || s.contains("0") || s.contains("1") || s.contains("9");
    }
}
