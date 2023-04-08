package A;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ginga
 * @since 22/3/2023 下午6:44
 */
public class WalkingMaster {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int t;
    static int a, b, c, d;
    static int[][] dir = {
            { 1, 1 },
            { -1, 0 }
    };
    static Queue<Node> queue = new LinkedList<>();
    
    public static void main(String[] args) {
        t = scanner.nextInt();

        while (t-- > 0) {
            if (!queue.isEmpty()) {
                queue.clear();
            }
            int min = Integer.MAX_VALUE;
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            d = scanner.nextInt();

            queue.offer(new Node(a, b, 0));

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                for (int i = 0; i < 2; i++) {
                    int nx = node.x + dir[i][0];
                    int ny = node.y + dir[i][1];

                    if (nx == c && ny == d) {
                        min = Math.min(min, node.step + 1);
                    }

                    queue.offer(new Node(nx, ny, node.step + 1));
                }
            }
            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        }
    }

    private static class Node {
        int x, y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}
