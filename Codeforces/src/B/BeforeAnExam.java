package B;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 23/3/2023 下午2:31
 */
public class BeforeAnExam {
    static int d, sumTime;
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int[][] times;
    static int[] ans;

    public static void main(String[] args) {
        d = scanner.nextInt();
        sumTime = scanner.nextInt();
        int maxSum = 0;
        int minSum = 0;
        times = new int[d][2];
        ans = new int[d];

        for (int i = 0; i < d; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
            maxSum += times[i][1];
            minSum += times[i][0];
        }

        if (maxSum < sumTime || minSum > sumTime) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < d; i++) {
            // 每天学最少时间
            sumTime -= times[i][0];
            ans[i] = times[i][0];
        }

        for (int i = 0; i < d; i++) {
            int extraTime;
            if (sumTime + ans[i] > times[i][1]) {
                extraTime = times[i][1] - ans[i];
                ans[i] = times[i][1];
                sumTime -= extraTime;
            } else {
                ans[i] += sumTime;
                break;
            }
        }

        System.out.println("YES");
        for (int time : ans) {
            System.out.print(time + " ");
        }
        System.out.println();
    }
}
