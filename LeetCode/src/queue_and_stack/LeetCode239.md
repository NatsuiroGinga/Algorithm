# LeetCode239 滑动窗口最大值

## 题意

给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

```text

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3

输出: [3,3,5,5,6,7]

解释:

  滑动窗口的位置                最大值

---------------               -----

[1  3  -1] -3  5  3  6  7       3

 1 [3  -1  -3] 5  3  6  7       3

 1  3 [-1  -3  5] 3  6  7       5

 1  3  -1 [-3  5  3] 6  7       5

 1  3  -1  -3 [5  3  6] 7       6

 1  3  -1  -3  5 [3  6  7]      7

```

提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

## 题解

1. 使用双端队列，队列中存储的是数组的下标
2. 遍历数组，如果队列不为空且队列中的最大值小于当前值，则将队列中的最大值弹出
3. 将当前值压入队列
4. 如果队列中的最大值的下标小于等于当前下标减去窗口大小，则将队列中的最大值弹出
5. 如果当前下标大于等于窗口大小减一，则将队列中的最大值压入结果数组
6. 时间复杂度：O(n)，空间复杂度：O(k)

## 代码

**python**

```python

class Solution:

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not nums:
            return []
        res = []
        queue = []
        for i in range(len(nums)):
            if queue and nums[queue[-1]] < nums[i]:
                queue.pop()
            queue.append(i)
            if queue[0] <= i - k:
                queue.pop(0)
            if i >= k - 1:
                res.append(nums[queue[0]])
        return res

```

**java**

```java

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

}

```
