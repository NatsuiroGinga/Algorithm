package queue_and_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ginga
 * @since 1/5/2023 上午8:28
 */
public class LeetCode20 {
    public static void main(String[] args) {
        String s = "[]";
        final LeetCode20 leetCode20 = new LeetCode20();
        System.out.println(leetCode20.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != map.get(c)) return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
