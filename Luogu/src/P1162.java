import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ginga
 * @since 14/8/2023 上午10:35
 */
public class P1162 {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));

    static int n, sx, sy;
    static int[][] matrix;
    static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };
    static boolean[][] vis;

    public static void main(String[] args) {
        n = input.nextInt();
        matrix = new int[n + 5][n + 5];
        vis = new boolean[n + 5][n + 5];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        bfs();
        print();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy));
        vis[sx][sy] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int[] pair : dir) {
                int nx = node.x + pair[0];
                int ny = node.y + pair[1];
                if (inArea(nx, ny) && matrix[nx][ny] == 0 && !vis[nx][ny]) {
                    q.offer(new Node(nx, ny));
                    vis[nx][ny] = true;
                }
            }
        }
    }

    static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] == 0) {
                    output.print(vis[i][j] ? "0 " : "2 ");
                } else output.print("1 ");
            }
            output.println();
        }
        output.flush();
    }

    static boolean inArea(int r, int c) {
        return r >= 0 && r <= n + 1 && c >= 0 && c <= n + 1;
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
