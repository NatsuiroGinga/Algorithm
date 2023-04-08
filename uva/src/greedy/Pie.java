package greedy;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 7/4/2023 下午7:16
 */
public class Pie {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int t, n, f;
    static double[] area;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            f = input.nextInt() + 1;
            area = new double[n];
            double maxArea = -1;

            for (int i = 0; i < n; i++) {
                area[i] = Math.PI * Math.pow(input.nextInt(), 2);
                maxArea = Math.max(maxArea, area[i]);
            }

            double low = 0, high = maxArea;
            while (high - low > 1e-5) {
                double mid = (low + high) / 2;
                if (check(mid)) {
                    low = mid;
                } else {
                    high = mid;
                }
            }

            output.append(String.format("%.4f\n", low));
        }

        System.out.print(output);
    }

    private static boolean check(double curArea) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += Math.floor(area[i] / curArea);
        }
        return count >= f;
    }
}
