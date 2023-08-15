//Given an integer array nums and an integer k, return the k most frequent 
//elements. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), 
//where n is the array's size. 
//
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority 
//Queue) Bucket Sort Counting Quickselect 👍 15295 👎 539


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<Pair> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));

            if (queue.size() > k) { // 维护k个元素, O(NlogK)
                queue.poll();
            }
        }

        int[] ans = new int[queue.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = queue.poll().val;
        }

        return ans;
    }
}

class Pair implements Comparable<Pair> {
    int val;
    int frq;

    Pair(int val, int frq) {
        this.frq = frq;
        this.val = val;
    }

    @Override
    public int compareTo(Pair pair) {
        return Integer.compare(this.frq, pair.frq);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
