/**
 * <a href="https://www.lanqiao.cn/problems/553/learning/?page=2&first_category_id=1&sort=students_count&category_id=3">
 * 既约分数
 * </a>
 *
 * @author ginga
 * @since 5/3/2023 下午4:08
 */
public class ApproximateScore {

    static int gcd(int a, int b) {
        if (a % b == 0)
            return b;

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        long count = 0;
        for (int i = 1; i <= 2020; i++) {
            for (int j = 1; j <= 2020; j++) {
                if (gcd(i, j) == 1)
                    count++;
            }
        }

        System.out.println(count);
    }
}
