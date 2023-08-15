//You are given an array of integers nums, there is a sliding window of size k 
//which is moving from the very left of the array to the very right. You can only 
//see the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic 
//Queue 👍 15236 👎 504


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            queue.push(nums[i]);
            cnt++;

            if (cnt == k) {
                ans.add(queue.getMaxValue());
                cnt--;
                queue.pop(nums[i-k+1]);
            }
        }

        return ans.stream().mapToInt(x -> x).toArray();
    }
}

class MonotonicQueue {
    private final Deque<Integer> deque;

    public MonotonicQueue() {
        deque = new LinkedList<>();
    }

    public void pop(int val) {
        if (!deque.isEmpty() && val == deque.peekFirst()) {
            deque.pollFirst();
        }
    }

    public void push(int val) {
        while (!deque.isEmpty() && val > deque.peekLast()) {
            deque.pollLast();
        }
        deque.addLast(val);
    }

    public int getMaxValue() {
        assert !deque.isEmpty();
        return deque.peekFirst();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
