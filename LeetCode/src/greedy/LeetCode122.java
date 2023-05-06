package greedy;

/**
 * @author ginga
 * @since 2/5/2023 上午10:22
 */
public class LeetCode122 {
    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 3, 6, 4 };
        LeetCode122 leetCode122 = new LeetCode122();
        System.out.println(leetCode122.maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        var ans = 0;

        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }

        return ans;
    }
}
