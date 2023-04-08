import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ginga
 * @since 7/4/2023 上午10:53
 */
public class P5788 {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int n;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            while (!stack.isEmpty() && stack.peek() < x) {
                
            }
        }
    }
}
