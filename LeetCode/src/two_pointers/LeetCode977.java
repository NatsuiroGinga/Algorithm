package two_pointers;

/**
 * @author ginga
 * @since 29/4/2023 上午10:17
 */
public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int k = nums.length - 1;

        for (int i = 0, j = nums.length - 1; i <= j; ) {
            int a = nums[i] * nums[i], b = nums[j] * nums[j];

            if (a > b) {
                ans[k--] = a;
                i++;
            } else {
                ans[k--] = b;
                j--;
            }
        }

        return ans;
    }
}
