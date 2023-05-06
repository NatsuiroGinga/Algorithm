package queue_and_stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ginga
 * @since 1/5/2023 上午9:33
 */
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int count = 0;

        for (int num : nums) {
            if (!queue.isEmpty() && num == queue.getFirst()) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && num > queue.getFirst()) {
                queue.removeLast();
            }

            queue.addLast(num);
            count++;

            if (count == k) {
                ans.add(queue.getFirst());
                count--;
            }
        }

        int[] ret = new int[ans.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = ans.get(i);
        }

        return ret;
    }
}
