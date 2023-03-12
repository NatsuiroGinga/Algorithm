/**
 * @author ginga
 * @since 10/3/2023 上午11:00
 */
public class GuessBirthday {
    public static void main(String[] args) {
        for (int year = 1901; year < 2013; year++) {
            for (int day = 1; day <= 31; day++) {
                final int x = year * 10000 + 6 * 100 + day;
                if (x % 2012 == 0 && x % 3 == 0 && x % 12 == 0) {
                    System.out.println(x);
                    return;
                }
            }
        }
    }
}
