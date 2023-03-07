import java.util.Scanner;

/**
 * <a href="https://www.lanqiao.cn/problems/497/learning/?page=1&first_category_id=1&sort=students_count">
 * 成绩分析
 * </a>
 *
 * @author ginga
 * @since 3/3/2023 上午8:08
 */
public class GradeAnalysis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max = 0, min = Integer.MAX_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            int score = scan.nextInt();
            max = Math.max(max, score);
            min = Math.min(min, score);
            sum += score;
        }

        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f", 1.0 * sum / n);

        scan.close();
    }
}
