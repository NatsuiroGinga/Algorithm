import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * <a href="https://www.lanqiao.cn/problems/1452/learning/?page=2&first_category_id=1&sort=students_count&category_id=3">
 * 时间显示
 * </a>
 *
 * @author ginga
 * @since 5/3/2023 下午8:24
 */
public class ShowTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long ms = input.nextLong();
        final LocalDateTime dateTime = LocalDateTime.ofEpochSecond(ms / 1000,
                                                                   0,
                                                                   ZoneOffset.UTC);
        final String format = dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(format);

        input.close();
    }
}
