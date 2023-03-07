/**
 * <a href="https://www.lanqiao.cn/problems/595/learning/?first_category_id=1&sort=students_count&second_category_id=3">
 * 七段码
 * </a>
 *
 * @author ginga
 * @since 4/3/2023 上午10:58
 */
public class SevenSegmentCode {
    static int[][] graph = {
            { 1, 1, 0, 0, 0, 1, 0 },
            { 1, 1, 1, 0, 0, 0, 1 },
            { 0, 1, 1, 1, 0, 0, 1 },
            { 0, 0, 1, 1, 1, 0, 0 },
            { 0, 0, 0, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 1, 1, 1 },
            { 0, 1, 1, 0, 1, 1, 1 }
    };

    static boolean[] visit = new boolean[7];

    static int ways(int cur) {
        int count = 1;
        for (int i = 0; i < 7; i++) {
            if (!visit[i] && graph[cur][i] == 1) {
                visit[i] = true;
                count += ways(i);
                visit[i] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(ways(0) / 2);
    }
}
