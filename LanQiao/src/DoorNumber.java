/**
 * <a href="https://www.lanqiao.cn/problems/592/learning/?page=1&first_category_id=1&sort=students_count&category_id=3">
 * 门牌制作
 * </a>
 *
 * @author ginga
 * @since 1/3/2023 上午8:11
 */
public class DoorNumber {
    public static void main(String[] args) {
        int ans = 0;

        for (int doorNumber = 1; doorNumber <= 2020; doorNumber++) {
            for (int j = doorNumber; j > 0; j /= 10) {
                if (j % 10 == 2) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
