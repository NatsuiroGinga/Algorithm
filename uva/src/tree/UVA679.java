package tree;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 25/4/2023 下午9:12
 */
public class UVA679 {
    private static final Scanner input = new Scanner(new BufferedInputStream(System.in));
    private static final PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int ball = input.nextInt();
            int k = 1;

            for (int i = 1; i < n; i++) {
                if (ball % 2 == 1) {
                    k *= 2;
                    ball = ball / 2 + 1;
                } else {
                    k = k * 2 + 1;
                    ball /= 2;
                }
            }

            output.println(k);
        }

        input.close();
        output.close();
    }
}
