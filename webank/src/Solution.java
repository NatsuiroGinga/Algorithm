/**
 * @author ginga
 * @since 12/4/2023 下午7:10
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param map int整型二维数组 代表地图的二维数组
     * @param a_x int整型 小 A 出生点的 x 坐标
     * @param a_y int整型 小 A 出生点的 y 坐标
     * @param b_x int整型 小 B 出生点的 x 坐标
     * @param b_y int整型 小 B 出生点的 y 坐标
     * @return int整型
     */
    private static int[][] ta, tb;
    private static int[][] dir = {
            { -1, 0 }, // 上
            { 1, 0 }, // 下
            { 0, -1 }, // 左
            { 0, 1 } // 右
    };
    private static int ans = Integer.MAX_VALUE;

    private static void bfs(int x, int y, int[][] t, int[][] map) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dir[i][0];
                int ny = n.y + dir[i][1];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length
                        && t[nx][ny] == 0 && map[nx][ny] != 0) {

                    t[nx][ny] = t[n.x][n.y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] map = {
                { 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 1, 1, 1 }, { 1, 0, 0, 0, 1 }
        };
        int a_x = 0, a_y = 0, b_x = 4, b_y = 4;
        final int estTime = getEstTime(map, a_x, a_y, b_x, b_y);
        System.out.println(estTime);
    }

    public static int getEstTime(int[][] map, int a_x, int a_y, int b_x, int b_y) {
        ta = new int[map.length][map[0].length];
        tb = new int[map.length][map[0].length];
        bfs(a_x, a_y, ta, map);
        bfs(b_x, b_y, tb, map);

        System.out.println(Arrays.deepToString(ta));
        System.out.println("=====");
        System.out.println(Arrays.deepToString(tb));

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (ta[i][j] != 0 && map[i][j] != 0 && ta[i][j] == tb[i][j]) {
                    ans = Math.min(ans, ta[i][j]);
                }
            }
        }

        return ans;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}