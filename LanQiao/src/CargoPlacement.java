import java.util.ArrayList;

/**
 * <a href="https://www.lanqiao.cn/problems/1463/learning/?page=1&first_category_id=1&sort=students_count">
 * 货物摆放
 * </a>
 *
 * @author ginga
 * @since 4/3/2023 上午10:06
 */
public class CargoPlacement {
    public static void main(String[] args) {
        long n = 2021041820210418L;
        long count = 0;
        final ArrayList<Long> arr = new ArrayList<>(100);

        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                arr.add(i);
                long o = n / i;
                if (i != o) {
                    arr.add(o);
                }
            }
        }

        for (Long m : arr)
            for (Long p : arr)
                for (Long l : arr)
                    if (m * p * l == n)
                        count++;
                    

        System.out.println(count);
    }
}
