import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author ginga
 * @since 3/3/2023 上午10:23
 */
public class Run {
    public static void main(String[] args) {
        LocalDate begin = LocalDate.of(2000, 1, 1);
        final LocalDate end = LocalDate.of(2020, 10, 1);
        int ans = 0;

        for (;
             begin.isBefore(end) || begin.isEqual(end);
             begin = begin.plusDays(1)) {

            if (begin.getDayOfWeek() == DayOfWeek.MONDAY || begin.getDayOfMonth() == 1) {
                ans += 2;
            } else {
                ans += 1;
            }
        }

        System.out.println(ans);
    }
}
