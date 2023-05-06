package greedy;

/**
 * @author ginga
 * @since 2/5/2023 上午10:34
 */
public class LeetCode55 {
    public static void main(String[] args) {
        var nums = new int[]{ 0, 2, 3 };
        LeetCode55 leetCode55 = new LeetCode55();
        System.out.println(leetCode55.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        var maxStep = 0;

        for (var step = 0; step < nums.length - 1 && step <= maxStep; step++) {
            maxStep = Math.max(maxStep, step + nums[step]);
        }

        return maxStep >= nums.length - 1;
    }
}
