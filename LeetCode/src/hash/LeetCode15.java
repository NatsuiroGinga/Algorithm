package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ginga
 * @since 27/4/2023 上午10:25
 */
public class LeetCode15 {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        final LeetCode15 leetCode15 = new LeetCode15();
        final List<List<Integer>> lists = leetCode15.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int low = i + 1, high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum < 0) low++;
                else if (sum > 0) high--;
                else {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    while (low + 1 < high && nums[low + 1] == nums[low]) low++;
                    while (low < high - 1 && nums[high - 1] == nums[high]) high--;

                    low++;
                    high--;
                }
            }
        }

        return ans;
    }
}
