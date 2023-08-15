package codeton_5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 7/8/2023 上午8:28
 */
public class A {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int t, n, m;

    public static void main(String[] args) {
        t = input.nextInt();
        while (t-- > 0) {
            long sum = 0;
            n = input.nextInt();
            m = input.nextInt();
            for (int i = 0; i < n; i++) {
                sum += input.nextInt();
            }
            for (int i = 0; i < m; i++) {
                sum -= input.nextInt();
            }
            if (sum > 0) output.println("Tsondu");
            else if (sum < 0) output.println("Tenzing");
            else output.println("Draw");
        }
    }
}
