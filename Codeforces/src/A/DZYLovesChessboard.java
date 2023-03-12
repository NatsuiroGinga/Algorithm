package A;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 7/3/2023 下午6:59
 */
public class DZYLovesChessboard {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] chess = new char[n + 5][m + 5];

        for (int i = 1; i <= n; i++) {
            String chessMan = scanner.next();
            for (int j = 1; j <= m; j++) {

                if (chessMan.charAt(j - 1) == '-')
                    chess[i][j] = '-';
                else if (chessMan.charAt(j - 1) == '.' && (i + j) % 2 == 0)
                    chess[i][j] = 'B';
                else
                    chess[i][j] = 'W';
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.printf("%c", chess[i][j]);
            }
            System.out.println();
        }

    }
}
