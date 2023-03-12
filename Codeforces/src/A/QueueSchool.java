package A;

import java.util.Scanner;

/**
 * @author ginga
 * @since 8/3/2023 下午3:02
 */
public class QueueSchool {
    static Scanner scanner = new Scanner(System.in);
    static int n, t;
    static String s;

    public static void main(String[] args) {
        n = scanner.nextInt();
        t = scanner.nextInt();
        s = scanner.next();
        final char[] queue = s.toCharArray();

        for (int j = 0; j < t; j++) {
            for (int i = 1; i < n; i++) {
                if (queue[i] == 'G' && queue[i - 1] == 'B') {
                    queue[i - 1] = 'G';
                    queue[i] = 'B';
                    i++;
                }
            }

        }

        System.out.println(String.valueOf(queue));
    }
}
