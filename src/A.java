package src;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ginga
 * @since 6/8/2023 下午8:16
 */
public class A {
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);
    static Scanner input = new Scanner(new BufferedInputStream(System.in));

    static int t, n, ans;

    public static void main(String[] args) {
        t = input.nextInt();
        while (t-- > 0) solve();
        output.println(ans);
    }

    private static void solve() {
        n = input.nextInt();
        List<String> q = new LinkedList<>();
        int friend = 0;

        for (int i = 0; i < n; i++) {
            q.add(input.next());
        }

        for (int i = 0; i < n; i++) {
            if (!input.next().equals(q.get(i))) {
                friend--;
                if (friend < 0) {
                    break;
                }
            } else {
                friend++;
            }
        }

        if (friend > 0) ans++;
    }
}
