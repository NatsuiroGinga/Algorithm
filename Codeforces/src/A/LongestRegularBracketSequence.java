package A;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author ginga
 * @since 12/3/2023 下午9:44
 */
public class LongestRegularBracketSequence {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static char[] str;
    static int maxLen;
    static int count;
    static int[] stack;
    static int[] mark;

    public static void main(String[] args) {
        str = scanner.next().toCharArray();
        stack = new int[str.length + 5];
        mark = new int[str.length + 5];

        for (int i = 0, top = 0; i < str.length; i++) {
            if (str[i] == '(') stack[++top] = i;
            else if (top > 0) {
                mark[stack[top--]] = 1;
                mark[i] = 1;
            }
        }

    }

}
