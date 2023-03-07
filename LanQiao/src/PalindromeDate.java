import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * <a href="https://www.lanqiao.cn/problems/498/learning/?page=1&first_category_id=1&sort=students_count">
 * 回文日期
 * </a>
 *
 * @author ginga
 * @since 28/2/2023 上午9:33
 */
public class PalindromeDate {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static boolean isPalindromeDate(char[] dateChars) {
        for (int i = 0; i < dateChars.length / 2; i++) {
            if (dateChars[i] != dateChars[dateChars.length - 1 - i])
                return false;
        }

        return true;
    }

    private static boolean isABABBABADate(char[] dateChars) {
        return isPalindromeDate(dateChars) &&
                dateChars[0] == dateChars[2] &&
                dateChars[1] == dateChars[3];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dateStr = scan.next();
        scan.close();
        LocalDate date = LocalDate.parse(dateStr, formatter);
        String palindromeDateStr = null,
                ABABBABADateStr;

        for (date = date.plusDays(1);
                ;
             date = date.plusDays(1)) {
            char[] dateChars = date.format(formatter)
                                   .toCharArray();

            if (palindromeDateStr == null && isPalindromeDate(dateChars)) {
                palindromeDateStr = date.format(formatter);
                System.out.println(palindromeDateStr);
            }

            if (isABABBABADate(dateChars)) {
                ABABBABADateStr = date.format(formatter);
                System.out.println(ABABBABADateStr);
                break;
            }
        }
    }
}
