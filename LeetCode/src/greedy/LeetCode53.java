package greedy;

/**
 * @author ginga
 * @since 2/5/2023 上午9:48
 */
public class LeetCode53 {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        LeetCode53 leetCode53 = new LeetCode53();
        System.out.println(leetCode53.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        var maxSum = nums[0];
        var curSum = 0;

        for (int num : nums) {
            curSum += num;
            maxSum = Math.max(maxSum, curSum);
            curSum = Math.max(0, curSum);
        }

        return maxSum;
    }
}
