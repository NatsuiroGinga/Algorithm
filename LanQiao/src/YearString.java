/**
 * <a href="https://www.lanqiao.cn/problems/605/learning/?page=2&first_category_id=1&sort=students_count&category_id=3">
 * 年号字串
 * </a>
 *
 * @author ginga
 * @since 7/3/2023 上午10:41
 */
public class YearString {
    public static void main(String[] args) {
        dfs(2019);
    }

    private static void dfs(int num) {
        if (num > 26) {
            dfs(num / 26);
        }
        System.out.print((char) (num % 26 + 64));
    }
}
