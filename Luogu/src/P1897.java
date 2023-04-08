import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.luogu.com.cn/problem/P1897">
 * P1897 电梯里的爱情
 * </a>
 *
 * @author ginga
 * @since 5/3/2023 下午10:01
 */
public class P1897 {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.computeIfPresent('1', (character, integer) -> integer + 1);
    }
}
