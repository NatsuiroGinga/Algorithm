import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ginga
 * @since 14/8/2023 上午8:44
 */
public class P1101 {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out), true);

    static int n;
    static long ans;
    static String[] words;
    static int[] amount;
    static char s;

    public static void main(String[] args) {
        n = input.nextInt();
        words = new String[n];
        amount = new int[n];
        for (int i = 0; i < n; i++) {
            words[i] = input.next();
            amount[i] = 2;
        }
        s = input.next().charAt(0);

        for (int i = 0; i < n; i++) {
            if (words[i].charAt(0) == s) {
                amount[i]--;
                dfs(i, words[i].length());
                amount[i]++;
            }
        }

        output.println(ans);
    }

    private static void dfs(int cur, long length) {
        ans = Math.max(ans, length);
        for (int i = 0; i < n; i++) {
            if (amount[i] == 0) continue;

            int delta = canJoin(cur, i);
            if (delta != -1) {
                amount[i]--;
                dfs(i, length + delta);
                amount[i]++;
            }
        }
    }

    // 判断两个字符串能否连接, 如果能, 返回连接后的字符串新增的长度
    // 否则返回-1
    private static int canJoin(int a, int b) {
        int p = 1;
        int lenA = words[a].length();
        int lenB = words[b].length();

        while (p < Math.min(lenA, lenB)) {
            if (words[a].substring(lenA - p).equals(words[b].substring(0, p))) {
                return words[b].length() - p;
            }
            p++;
        }

        return -1;
    }
}
