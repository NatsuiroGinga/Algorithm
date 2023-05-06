package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ginga
 * @since 6/5/2023 上午9:54
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>(List.of(new int[]{ intervals[0][0], intervals[0][1] }));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }

        return ans.toArray(new int[][]{});
    }
}
