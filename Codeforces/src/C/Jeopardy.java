package C;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 23/3/2023 下午4:36
 */
public class Jeopardy {
    static Scanner in = new Scanner(new BufferedInputStream(System.in));
    static int n, m;
    static int[] auctions, questions;

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        questions = new int[n + 5];
        auctions = new int[m + 5];
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            questions[i] = in.nextInt();
            sum += questions[i];
        }

        for (int i = 1; i <= m; i++) {
            auctions[i] = questions[in.nextInt()];
            sum -= auctions[i];
        }

        Arrays.sort(auctions);

        for (int i = auctions.length - 1; i >= 0; i--) {
            if (auctions[i] != 0)
                sum = Math.max(sum * 2, sum + auctions[i]);
        }

        System.out.println(sum);
    }

}
