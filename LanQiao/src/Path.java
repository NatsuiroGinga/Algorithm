/**
 * <a href="https://www.lanqiao.cn/problems/1460/learning/?page=2&first_category_id=1&sort=students_count&category_id=3">
 * 路径
 * </a>
 *
 * @author ginga
 * @since 6/3/2023 上午8:03
 */
public class Path {

    static int[] f = new int[2022];

    private static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 2021; i++) {
            for (int j = i + 1; j <= i + 21; j++) {
                if (j > 2021) break;
                if (f[j] == 0)
                    f[j] = lcm(i, j) + f[i];
                else
                    f[j] = Math.min(f[j], f[i] + lcm(i, j));
            }
        }
        System.out.println(f[2021]);
    }
}
