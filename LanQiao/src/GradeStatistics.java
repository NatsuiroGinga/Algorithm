import java.util.Scanner;

/**
 * <a href="https://www.lanqiao.cn/problems/502/learning/?page=1&first_category_id=1&sort=students_count">
 * 成绩统计
 * </a>
 *
 * @author ginga
 * @since 28/2/2023 上午9:02
 */
public class GradeStatistics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int passingCount = 0, excellentCount = 0;

        for (int i = 0; i < size; i++) {
            int score = scan.nextInt();
            if (score >= 60) {
                passingCount++;
                if (score >= 85) {
                    excellentCount++;
                }
            }
        }
        scan.close();

        System.out.printf("%d%%\n", Math.round(passingCount * 1.0 / size * 100));
        System.out.printf("%d%%\n", Math.round(excellentCount * 1.0 / size * 100));
    }
}
