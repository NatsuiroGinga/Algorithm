/**
 * <a href="https://www.lanqiao.cn/problems/1443/learning/?page=1&first_category_id=1&sort=students_count&category_id=3">
 * 卡片
 * </a>
 *
 * @author ginga
 * @since 1/3/2023 上午8:16
 */
public class Card {
    public static void main(String[] args) {
        int count = 0;
        int num;
        for (num = 1; ; num++) {
            for (int unit = num; unit > 0; unit /= 10) {
                if (count >= 2021) break;
                else if (unit % 10 == 1) {
                    count++;
                }
            }
            if (count >= 2021) break;
        }

        System.out.println(num);
    }
}
