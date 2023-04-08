package ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ginga
 * @since 27/3/2023 上午10:13
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[i] + nums[high];

                if (sum < 0) {
                    low++;
                } else if (sum > 0) {
                    high--;
                } else {
                    Integer[] sub = { nums[i], nums[low], nums[high] };
                    final List<Integer> list = Arrays.asList(sub);

                    if (!ans.contains(list)) {
                        ans.add(list);
                    }
                    
                    low++;
                    high--;
                }
            }
        }

        return ans;
    }
}
