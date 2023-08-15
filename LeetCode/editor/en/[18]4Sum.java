//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 9876 👎 1173


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[left] + nums[right] + nums[j] + nums[i];

                    if (sum == target) {
                        ans.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        for (; left + 1 < right && nums[left] == nums[left + 1]; left++) ;
                        for (; right - 1 > left && nums[right] == nums[right - 1]; right--) ;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
