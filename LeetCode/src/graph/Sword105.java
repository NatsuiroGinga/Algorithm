package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ginga
 * @since 27/4/2023 下午8:35
 */
public class Sword105 {
    private static final int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (vis[i][j] || grid[i][j] == 0) continue;

                int area = getArea2(grid, vis, i, j);
                ans = Math.max(ans, area);
            }
        }

        return ans;
    }

    private int getArea1(int[][] grid, boolean[][] vis, int row, int col) {
        int area = 1;
        vis[row][col] = true;

        for (int[] pair : dir) {
            int nRow = pair[0] + row;
            int nCol = pair[1] + col;
            if (nRow >= 0 && nRow < grid.length
                    && nCol >= 0 && nCol < grid[nRow].length
                    && !vis[nRow][nCol] && grid[nRow][nCol] == 1) {

                area += getArea1(grid, vis, nRow, nCol);
            }
        }

        return area;
    }

    private int getArea2(int[][] grid, boolean[][] vis, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ row, col });
        vis[row][col] = true;
        int area = 0;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            area++;

            for (int[] p : dir) {
                int nx = p[0] + pair[0];
                int ny = p[1] + pair[1];

                if (nx >= 0 && nx < grid.length
                        && ny >= 0 && ny < grid[nx].length
                        && !vis[nx][ny] && grid[nx][ny] == 1) {

                    vis[nx][ny] = true;
                    queue.offer(new int[]{ nx, ny });
                }
            }
        }

        return area;
    }
}
