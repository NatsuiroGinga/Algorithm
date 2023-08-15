package codeton_5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 7/8/2023 上午8:42
 */
public class B {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int t, n;
    static long x;

    public static void main(String[] args) {
        t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            x = input.nextLong();
            long[] books = new long[n];
            long know = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n; j++) {
                    books[j] = input.nextLong();
                }
                for (long book : books) {
                    if ((book & x) == book) { // 检查当前书的值是否是x的子集
                        know |= book;
                    } else {
                        break;
                    }
                }
            }

            output.println(know == x ? "Yes" : "No");
        }
    }
}
