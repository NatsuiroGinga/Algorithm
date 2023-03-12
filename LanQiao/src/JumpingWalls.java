import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author ginga
 * @since 10/3/2023 下午5:16
 */
public class JumpingWalls {
    static int n, k;
    static Map<String, String> walls = new HashMap<>(2);
    static Set<String> vis;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        n = scanner.nextInt();
        k = scanner.nextInt();
        vis = new HashSet<>();

        walls.put("left", scanner.next());
        walls.put("right", scanner.next());

        System.out.println(dfs(1, 1, "left") ? "YES" : "NO");
    }

    private static boolean dfs(int water, int cur, String pattern) {
        if (cur <= 0) return false;
        if (cur > n) return true;
        if (walls.get(pattern).charAt(cur - 1) == 'X') {
            return false;
        }
        if (vis.contains(pattern + cur)) {
            return false;
        }
        if (water >= n - 1) {
            return false;
        }
        vis.add(pattern + cur);

        return dfs(water + 1, cur + k, Objects.equals(pattern, "left") ? "right" : "left") ||
                dfs(water + 1, cur + 1, pattern) ||
                dfs(water + 1, cur - 1, pattern);
    }
}
