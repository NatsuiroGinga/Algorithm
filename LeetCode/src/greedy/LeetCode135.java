package greedy;

import java.util.Arrays;

/**
 * @author ginga
 * @since 5/5/2023 上午9:29
 */
public class LeetCode135 {
    public int candy(int[] ratings) {
        int[] c = new int[ratings.length];
        c[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                c[i] = c[i - 1] + 1;
            else
                c[i] = 1;
        }

        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i])
                c[i - 1] = Math.max(c[i - 1], c[i] + 1);
        }

        return Arrays.stream(c).sum();
    }
}
