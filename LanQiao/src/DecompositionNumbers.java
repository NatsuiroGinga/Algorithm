/**
 * <a href="https://www.lanqiao.cn/problems/606/learning/?page=2&first_category_id=1&sort=students_count&category_id=3">
 * 数的分解
 * </a>
 *
 * @author ginga
 * @since 8/3/2023 上午10:49
 */
public class DecompositionNumbers {

    static int count;

    private static boolean hasTwoOrFour(int x) {
        final String s = String.valueOf(x);
        return s.contains("2") || s.contains("4");
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 2019 / 3; i++) {
            for (int j = i + 1; j < 2019 / 3 * 2; j++) {
                int k = 2019 - i - j;
                if (k > j && !hasTwoOrFour(k) && !hasTwoOrFour(i) && !hasTwoOrFour(j)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
