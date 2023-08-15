import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ginga
 * @since 14/8/2023 上午11:28
 */
public class P1443 {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));
    static int n, m, x, y;
    static int[][] matrix;
    static int[][] dir = {
            { -1, -2 }, // 左上
            { -2, -1 },
            { -1, 2 }, // 右上
            { -2, 1 },
            { 1, -2 }, // 左下
            { 2, -1 },
            { 1, 2 }, // 右下
            { 2, 1 }
    };

    public static void main(String[] args) {
        n = input.nextInt();
        m = input.nextInt();
        x = input.nextInt();
        y = input.nextInt();
        final int MAX_N = n + 5;
        final int MAX_M = m + 5;
        matrix = new int[MAX_N][MAX_M];
        for (int[] row : matrix) Arrays.fill(row, -1);

        bfs();
        print();
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        matrix[x][y] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int[] pair : dir) {
                int nx = node.x + pair[0];
                int ny = node.y + pair[1];
                if (inArea(nx, ny) && matrix[nx][ny] == -1) {
                    Node next = new Node(nx, ny);
                    matrix[nx][ny] = matrix[node.x][node.y] + 1;
                    q.offer(next);
                }
            }
        }
    }

    private static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                output.print(matrix[i][j] + " ");
            }
            output.println();
        }
        output.flush();
    }

    static boolean inArea(int r, int c) {
        return r >= 1 && r <= n && c >= 1 && c <= m;
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
