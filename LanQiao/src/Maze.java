import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {

    static Queue<Node> queue = new LinkedList<>();
    static char[][] maze = new char[35][55];
    static boolean[][] visit = new boolean[35][55];
    static int[] dx = { 1, 0, 0, -1 };
    static int[] dy = { 0, -1, 1, 0 };
    static char[] dir = { 'D', 'L', 'R', 'U' };
    static String finalPath = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        for (int i = 0; i < 30; i++) {
            maze[i] = scanner.nextLine().toCharArray();
        }
        scanner.close();

        queue.add(new Node(0, 0, ""));

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            String s = node.path;
            if (x == 29 && y == 49) {
                finalPath = s;
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx <= 29 &&
                        ny >= 0 && ny <= 49 &&
                        maze[nx][ny] == '0' &&
                        !visit[nx][ny]) {

                    queue.add(new Node(nx, ny, s + dir[i]));
                    visit[nx][ny] = true;
                }
            }
        }

        System.out.println(finalPath);
    }

    private static class Node {
        int x, y;
        String path;

        public Node(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}