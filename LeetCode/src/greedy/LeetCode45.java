package greedy;

/**
 * @author ginga
 * @since 2/5/2023 上午11:03
 */
public class LeetCode45 {
    public static void main(String[] args) {
        var nums = new int[]{ 2, 3, 0, 1, 4 };
        LeetCode45 leetCode45 = new LeetCode45();
        System.out.println(leetCode45.jump(nums));
    }

    public int jump(int[] nums) {
        int curFarthest = 0, jumps = 0, curEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);

            if (curFarthest >= nums.length - 1) return jumps + 1;

            if (i == curEnd) {
                curEnd = curFarthest;
                jumps++;
            }
        }

        return jumps;
    }
}
