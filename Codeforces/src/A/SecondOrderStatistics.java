package A;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ginga
 * @since 7/3/2023 下午3:48
 */
public class SecondOrderStatistics {
    public static void main(String[] args) {
        final Scanner input = new Scanner(new BufferedInputStream(System.in));
        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[0]) {
                System.out.print(arr[i]);
                return;
            }
        }

        System.out.print("NO");
    }
}
