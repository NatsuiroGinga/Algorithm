//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not 
//matter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 27076 👎 2446


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);

        for (int start = 0; start < nums.length - 2; start++) {
            if (start > 0 && nums[start] == nums[start - 1]) continue;

            int left = start + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[start] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(List.of(nums[start], nums[left], nums[right]));
                    for (; left + 1 < right && nums[left] == nums[left + 1]; left++) ;
                    for (; right - 1 > left && nums[right] == nums[right - 1]; right--) ;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
