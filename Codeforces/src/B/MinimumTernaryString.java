package B;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 23/3/2023 下午3:18
 */
public class MinimumTernaryString {
    static Scanner in = new Scanner(new BufferedInputStream(System.in));
    static String s;
    static StringBuilder one = new StringBuilder();
    static StringBuilder other = new StringBuilder();

    public static void main(String[] args) {
        s = in.next();

        char[] sChars = s.toCharArray();
        for (char sChar : sChars) {
            if (sChar == '1') {
                one.append('1');
            } else {
                other.append(sChar);
            }
        }

        final int firstTowIndex = other.indexOf("2");
        if (firstTowIndex != -1) {
            other.insert(firstTowIndex, one);
        } else {
            other.append(one);
        }

        System.out.println(other);
    }
}
