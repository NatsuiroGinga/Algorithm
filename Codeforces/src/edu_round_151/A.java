package edu_round_151;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ginga
 * @since 5/8/2023 上午8:09
 */
public class A {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int t, n, k, x;

    public static void main(String[] args) {
        t = input.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        n = input.nextInt();
        k = input.nextInt();
        x = input.nextInt();
        String ret = "NO";
        int count = 0;
        List<Integer> comb = new LinkedList<>();

        if (x != 1) {
            ret = "YES";
            count = n;
            for (; n > 0; n--) {
                comb.add(1);
            }
        } else { // x = 1
            if (k == 2 && (n & 1) == 0) {
                ret = "YES";
                count = n / 2;
                for (; n > 0; n -= 2) {
                    comb.add(2);
                }
            } else if (k >= 3) {
                if ((n & 1) == 0) {
                    ret = "YES";
                    count = n / 2;
                    for (; n > 0; n -= 2) {
                        comb.add(2);
                    }
                } else {
                    ret = "YES";
                    for (; n > 3; n -= 2) {
                        count++;
                        comb.add(2);
                    }
                    count++;
                    comb.add(3);
                }
            }
        }

        if ("YES".equals(ret)) {
            output.println(ret);
            output.println(count);
            for (Integer num : comb) {
                output.print(num + " ");
            }
            output.println();
        } else {
            output.println(ret);
        }
    }
}
