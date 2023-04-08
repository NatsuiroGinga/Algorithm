import java.util.Stack;

/**
 * @author ginga
 * @since 7/4/2023 下午1:31
 */
public class Leetcode739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                final Integer index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }

        return ans;
    }
}
