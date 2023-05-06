package queue_and_stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ginga
 * @since 1/5/2023 上午11:03
 */
public class LeetCode347 {
    private List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0 && ans.size() < k; i--) {
            if (bucket[i] != null) {
                ans.addAll(bucket[i]);
            }
        }

        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> list = topKFrequent2(nums, k);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
