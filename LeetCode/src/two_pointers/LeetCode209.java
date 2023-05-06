package two_pointers;

/**
 * @author ginga
 * @since 29/4/2023 上午10:33
 */
public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, sum = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                ans = Math.min(ans, j - i);
                i++;
                sum -= nums[i];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
