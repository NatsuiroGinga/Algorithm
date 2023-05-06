package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ginga
 * @since 27/4/2023 下午9:29
 */
public class Sword107 {
    private static final int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dis = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{ i, j });
                    dis[i][j] = 0;
                } else {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int distance = dis[pair[0]][pair[1]];

            for (int[] d : dir) {
                int nx = d[0] + pair[0];
                int ny = d[1] + pair[1];

                if (nx >= 0 && nx < rows
                        && ny >= 0 && ny < cols) {
                    if (dis[nx][ny] > distance + 1) {
                        dis[nx][ny] = distance + 1;
                        queue.offer(new int[]{ nx, ny });
                    }
                }
            }

        }

        return dis;
    }
}
