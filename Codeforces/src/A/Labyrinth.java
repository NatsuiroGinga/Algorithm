package A;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ginga
 * @since 12/3/2023 下午3:45
 */
public class Labyrinth {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int n, m;
    static int r, c;
    static int x, y;
    static char[][] maze;
    static int count = 1;
    static int[][] dir = {
            { -1, 0, 0, 0 },
            { 1, 0, 0, 0 },
            { 0, -1, 1, 0 },
            { 0, 1, 0, 1 }
    };

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();

        maze = new char[n + 5][m + 5];

        for (int i = 1; i <= n; i++) {
            char[] s = scanner.next().toCharArray();
            if (m >= 0) System.arraycopy(s, 0, maze[i], 1, m);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, 0, 0));
        Node[][] p = new Node[n + 5][m + 5];
        p[r][c] = new Node(r, c, 0, 0);
        maze[r][c] = '+';

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int[] pair : dir) {
                int nx = pair[0] + node.x;
                int ny = pair[1] + node.y;
                int nl = pair[2] + node.lStep;
                int nr = pair[3] + node.rStep;

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                    if (maze[nx][ny] == '.' && nl <= x && nr <= y) {
                        queue.add(new Node(nx, ny, nl, nr));
                        p[nx][ny] = new Node(0, 0, nl, nr);
                        maze[nx][ny] = '+';
                        count++;

                    } else if (maze[nx][ny] == '+') {
                        if (nl < p[nx][ny].lStep && nr < p[nx][ny].rStep) {
                            queue.add(new Node(nx, ny, nl, nr));
                            p[nx][ny].lStep = nl;
                            p[nx][ny].rStep = nr;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static class Node {
        int x, y, lStep, rStep;

        public Node(int x, int y, int lStep, int rStep) {
            this.x = x;
            this.y = y;
            this.lStep = lStep;
            this.rStep = rStep;
        }
    }

}
