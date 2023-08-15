package meituan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 12/8/2023 上午10:04
 */
public class A {
    private static Scanner input = new Scanner(new BufferedInputStream(System.in));
    private static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    private static int n, x, y;
    private static int[] a;

    public static void main(String[] args) {
        n = input.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        x = input.nextInt();
        y = input.nextInt();

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] == x && a[i] == y || a[i - 1] == y && a[i] == x) {
                output.println("Yes");
                return;
            }
        }

        output.println("No");
    }
}
