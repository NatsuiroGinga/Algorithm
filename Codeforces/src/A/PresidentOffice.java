package A;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 8/3/2023 下午3:17
 */
public class PresidentOffice {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int n, m;
    static char[][] room;
    static char pColor;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        pColor = scanner.next().charAt(0);
        room = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            room[i] = s.toCharArray();
        }
    }
}
