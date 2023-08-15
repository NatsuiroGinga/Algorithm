package round_885;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ginga
 * @since 3/8/2023 上午8:53
 */
public class B {
    static Scanner in = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int t, n, k, c;

    public static void main(String[] args) {
        t = in.nextInt();
        while (t-- > 0) {
            n = in.nextInt();
            k = in.nextInt();
            List<Integer>[] colors = new List[k];
            for (int i = 0; i < colors.length; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0);
                colors[i] = list;
            }

            for (int i = 1; i <= n; i++) {
                c = in.nextInt();
                colors[c - 1].add(i);
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                colors[i].add(n + 1);
                res = Math.min(res, solve(colors[i]));
            }

            out.println(res);
        }
    }

    private static int solve(List<Integer> color) {
        List<Integer> t = new ArrayList<>();
        for (int i = 1; i < color.size(); i++) {
            t.add(color.get(i) - color.get(i - 1));
        }

        t = t.stream().sorted((x, y) -> Integer.compare(y, x)).toList();

        if (t.size() == 1) return t.get(0) - 1;

        return Math.max(t.get(1) - 1, (t.get(0) - 1) / 2);
    }
}
