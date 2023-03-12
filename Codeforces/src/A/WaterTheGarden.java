package A;

import java.io.BufferedInputStream;
import java.util.*;

public class WaterTheGarden {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int t = scanner.nextInt();
        final Queue<Node> queue = new LinkedList<>();
        final Map<Integer, Boolean> visit = new HashMap<>();

        while (t-- != 0) {
            int ans = Integer.MIN_VALUE;
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            for (int i = 0; i < k; i++) {
                final Node node = new Node(scanner.nextInt(), 1);
                visit.put(node.pos, Boolean.TRUE);
                queue.add(node);
            }

            while (!queue.isEmpty()) {
                final Node garden = queue.poll();
                ans = Math.max(garden.time, ans);

                final int left = garden.pos - 1;
                if (left >= 1 && !visit.containsKey(left)) {
                    visit.put(left, Boolean.TRUE);
                    queue.add(new Node(left, garden.time + 1));
                }

                final int right = garden.pos + 1;
                if (right <= n && !visit.containsKey(right)) {
                    visit.put(right, Boolean.TRUE);
                    queue.add(new Node(right, garden.time + 1));
                }
            }

            System.out.println(ans);
            visit.clear();
        }
    }

    private static class Node {
        int pos;
        int time;

        Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}