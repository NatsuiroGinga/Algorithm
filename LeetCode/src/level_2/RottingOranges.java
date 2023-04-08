package level_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ginga
 * @since 25/3/2023 上午10:04
 */
public class RottingOranges {
    static Queue<Cell> queue = new LinkedList<>();
    static int ans = 0;
    static int[][] minutes;
    static int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        minutes = new int[n][m];
        int sx = -1, sy = -1;
        ans = 0;
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                switch (grid[i][j]) {
                    case 1:
                        fresh++;
                        break;
                    case 2:
                        queue.offer(new Cell(i, j));
                        break;
                }
            }
        }

        while (!queue.isEmpty()) {
            final Cell cell = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dir[i][0];
                int ny = cell.y + dir[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                    minutes[nx][ny] = minutes[cell.x][cell.y] + 1;
                    grid[nx][ny] = 2;
                    ans = Math.max(ans, minutes[nx][ny]);
                    fresh--;
                    queue.offer(new Cell(nx, ny));
                }
            }
        }

        if (fresh != 0) {
            return -1;
        }

        return ans;
    }

    private static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
