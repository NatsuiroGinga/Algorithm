package A;

import java.io.BufferedInputStream;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ginga
 * @since 22/3/2023 下午7:12
 */
public class USBFlashDrives {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int n, m;
    static Queue<Integer> disks = new PriorityQueue<>((x, y) -> {
        switch (Integer.compare(x, y)) {
            case 1:
                return -1;
            case -1:
                return 1;
            default:
                return 0;
        }
    });
    static int ans;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            disks.offer(scanner.nextInt());
        }

        while (m > 0) {
            m -= disks.poll();
            ans++;
        }

        System.out.println(ans);
    }
}
