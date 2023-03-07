/**
 * <a href="https://www.lanqiao.cn/problems/594/learning/?page=1&first_category_id=1&sort=students_count">
 * 蛇形填数
 * </a>
 *
 * @author ginga
 * @since 3/3/2023 上午10:01
 */
public class SerpentineFilling {
    public static void main(String[] args) {
        int ans = 1;
        for (int i = 1; i <= 20; i++) {
            ans += 4 * i;
        }
        System.out.println(ans);
    }
}
