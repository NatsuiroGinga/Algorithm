package greedy;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 24/3/2023 上午9:27
 */
public class TheDragonOfLoowater {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int[] heads;
    static int[] knights;
    static int n, m;

    public static void main(String[] args) {
        for (n = input.nextInt(), m = input.nextInt();
             n != 0 && m != 0;
             n = input.nextInt(), m = input.nextInt()) {

            heads = new int[n];
            knights = new int[m];

            for (int i = 0; i < n; i++) {
                heads[i] = input.nextInt();
            }

            for (int i = 0; i < m; i++) {
                knights[i] = input.nextInt();
            }

            Arrays.sort(heads);
            Arrays.sort(knights);

            int curHead = 0;
            int minCost = 0;

            for (int knight : knights) {
                if (knight >= heads[curHead]) {
                    minCost += knight;
                    if (++curHead == n) break;
                }
            }

            if (curHead < n) {
                System.out.println("Loowater is doomed!");
            } else {
                System.out.println(minCost);
            }
        }
    }
}
