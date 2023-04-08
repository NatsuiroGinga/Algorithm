package B;

import java.io.BufferedInputStream;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ginga
 * @since 23/3/2023 下午2:55
 */
public class ChessTourney {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int n;
    static Queue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        n = scanner.nextInt() * 2;
        for (int i = 0; i < n; i++) {
            queue.offer(scanner.nextInt());
        }

        Integer num1 = 0, num2;

        for (int i = 0; i < n / 2; i++) {
            num1 = queue.poll();
        }
        num2 = queue.poll();

        System.out.println(Objects.equals(num1, num2) ? "NO" : "YES");
    }
}
