package greedy;

import java.io.BufferedInputStream;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ginga
 * @since 27/3/2023 上午9:47
 */
public class CommandoWar {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int n;
    static Queue<Soldier> soldiers = new PriorityQueue<>();

    public static void main(String[] args) {
        int t = 1;
        for (n = input.nextInt(); n != 0; n = input.nextInt()) {
            for (int i = 0; i < n; i++) {
                final Soldier soldier = new Soldier(input.nextInt(), input.nextInt());
                soldiers.offer(soldier);
            }
            int s = 0, ans = 0;
            while (!soldiers.isEmpty()) {
                final Soldier soldier = soldiers.poll();
                s += soldier.b; // 当前任务的开始时间
                ans = Math.max(ans, soldier.j + s); // 更新任务执行完毕的最晚时间
            }

            System.out.printf("Case %d: %d\n", t++, ans);
        }
    }

    private static class Soldier implements Comparable<Soldier> {
        private final int b;
        private final int j;

        public Soldier(int b, int j) {
            this.b = b;
            this.j = j;
        }

        @Override
        public int compareTo(Soldier o) {
            return Integer.compare(o.j, this.j);
        }
    }
}
