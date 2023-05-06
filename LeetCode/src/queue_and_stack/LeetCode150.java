package queue_and_stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author ginga
 * @since 1/5/2023 上午8:53
 */
public class LeetCode150 {
    public static void main(String[] args) {
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        LeetCode150 leetCode150 = new LeetCode150();
        System.out.println(leetCode150.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for (String token : tokens) {
            if (set.contains(token)) {
                int num2 = nums.pop();
                int num1 = nums.pop();

                switch (token) {
                    case "+":
                        nums.push(num1 + num2);
                        break;
                    case "-":
                        nums.push(num1 - num2);
                        break;
                    case "*":
                        nums.push(num1 * num2);
                        break;
                    case "/":
                        nums.push(num1 / num2);
                        break;
                }
            } else {
                nums.push(Integer.parseInt(token));
            }
        }

        return nums.pop();
    }
}
