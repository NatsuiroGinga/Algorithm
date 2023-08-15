//Given two integer arrays nums1 and nums2, return an array of their 
//intersection. Each element in the result must be unique and you may return the result in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]
//Explanation: [4,9] is also accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics Array Hash Table Two Pointers Binary Search Sorting 👍 4952 👎
// 2148


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums1) {
            freq.putIfAbsent(num, 1);
        }
        for (int num : nums2) {
            freq.computeIfPresent(num, (k, v) -> 2);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 2) {
                ans.add(entry.getKey());
            }
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
