import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * <a href="https://www.lanqiao.cn/problems/504/learning/?page=1&first_category_id=1&sort=students_count">
 *  单词分析
 * </a>
 * @author ginga
 * @since 28/2/2023 上午8:26
 */
public class WordAnalysis {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        String word = scan.next();
        char[] chars = word.toCharArray();
        char ret = 0;
        int max = 0;

        for (char c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.computeIfPresent(c, (character, integer) -> integer + 1);
                final Integer v = map.get(c);
                if (v > max) {
                    max = v;
                    ret = c;
                }
            }
        }

        scan.close();

        System.out.println(ret);
        System.out.println(max);
    }
}
