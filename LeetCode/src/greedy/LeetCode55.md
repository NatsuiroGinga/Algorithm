# LeetCode55. 跳跃游戏

## 题意

给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。

示例 1:

```
输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
```

示例 2:

```
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。
但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
```

## 题解

### 方法一：贪心

我们可以用贪心的方法解决这个问题。

设想一下，对于数组中的任意一个位置 y，我们如何判断它是否可以到达？根据题目的描述，只要存在一个位置 x，它本身可以到达，并且它跳跃的最大长度为
x + nums[x]，这个值大于等于 y，即 x + nums[x]≥y，那么位置 y 也可以到达。

换句话说，对于每一个可以到达的位置 x，它使得 x+1, x+2,⋯,x+nums[x] 这些连续的位置都可以到达。

这样以来，我们依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置。对于当前遍历到的位置 x，如果它在 最远可以到达的位置
的范围内，那么我们就可以从起点通过若干次跳跃到达该位置，因此我们可以用 x+nums[x] 更新 最远可以到达的位置。

在遍历的过程中，如果 最远可以到达的位置 大于等于数组中的最后一个位置，那就说明最后一个位置可达，我们就可以直接返回 True
作为答案。反之，如果在遍历结束后，最后一个位置仍然不可达，我们就返回 False 作为答案。

实际代码中，我们不需要显式地记录 最远可以到达的位置，我们只需要记录当前可以到达的位置的最大值，记为

**java**

```java

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

**python**

```python

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        rightmost = 0
        for i in range(n):
            if i <= rightmost:
                rightmost = max(rightmost, i + nums[i])
                if rightmost >= n - 1:
                    return True
        return False
```

**复杂度分析**

- 时间复杂度：O(n)，其中 n 为数组的大小。只需要访问 nums 数组一遍，共 n 个位置。
- 空间复杂度：O(1)，不需要额外的空间开销。

### 方法二：动态规划

1. 我们定义 `dp[i]` 表示能否从起点跳到 `i`。
2. 初始化 `dp[0] = True`，其余为 `False`。
3. 我们枚举 `i` 从 `1` 到 `n-1`，对于每个 `i`，我们再次从 `0` 到 `i-1` 进行枚举，如果 `dp[j]` 为 `True`
   且 `j + nums[j] >= i`，则我们可以从 `j` 跳到 `i`，因此将 `dp[i]` 设为 `True`。
4. 在枚举结束之后，如果 `dp[n-1]` 为 `True`，则说明我们可以从起点跳到终点，否则不能。
5. 由于我们在最开始的时候，如果 `nums[0] = 0`，那么我们无法起跳，因此会直接返回 `False`
   ，因此不会进入上述循环，也不会进行状态转移，对于这种情况我们需要特殊判断。
6. 由于每个位置最多只需要跳跃的次数，因此时间复杂度为 `O(n^2)`。
7. 由于我们需要额外的数组来记录每个位置是否可以到达，因此空间复杂度为 `O(n)`。

**java**

```java

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
```

**python**

```python

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [False] * n
        dp[0] = True
        for i in range(1, n):
            for j in range(i):
                if dp[j] and j + nums[j] >= i:
                    dp[i] = True
                    break
        return dp[n - 1]
```

# Leetcode45. 跳跃游戏 II

## 题目描述

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

**示例:**

```text

输入:[2,3,1,1,4]

输出:2

解释:跳到最后一个位置的最小跳跃数是 2。
    从下标为 0跳到下标为 1的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
```

**说明:**

假设你总是可以到达数组的最后一个位置。

## 题解

### 方法一：贪心

与上一题类似，我们可以用贪心的方法解决这个问题。

设想一下，对于数组中的任意一个位置 y，我们如何判断它是否可以到达？根据题目的描述，只要存在一个位置 x，它本身可以到达，并且它

**还可以跳跃到位置 y**，那么位置 y 也可以到达。

换句话说，对于每一个可以到达的位置 x，它使得 x+1, x+2,⋯,x+nums[x] 这些连续的位置都可以到达。

这样以来，我们依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置。对于当前遍历到的位置 x，如果它在 最远可以到达的位置
的范围内，那么我们就可以从起点通过若干次跳跃到达该位置，因此我们可以用 x+nums[x] 更新 最远可以到达的位置。

在遍历的过程中，如果 最远可以到达的位置 大于等于数组中的最后一个位置，那就说明最后一个位置可达，我们就可以直接返回当前的遍历次数。

**java**

```java

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; ++i) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                ++steps;
            }
        }
        return steps;
    }
}
```

**python**

```python

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        end, maxPosition, steps = 0, 0, 0
        for i in range(n - 1):
            maxPosition = max(maxPosition, i + nums[i])
            if i == end:
                end = maxPosition
                steps += 1
        return steps
```

### 方法二：动态规划

1. 我们定义 `dp[i]` 表示从起点跳到 `i` 的最小跳跃次数。
2. 初始化 `dp[0] = 0`，其余为 `+∞`。
3. 我们枚举 `i` 从 `1` 到 `n-1`，对于每个 `i`，我们再次从 `0` 到 `i-1` 进行枚举，如果 `dp[j]` 为 `+∞`
   且 `j + nums[j] >= i`，则我们可以从 `j` 跳到 `i`，因此将 `dp[i]` 设为 `dp[j] + 1`。
4. 在枚举结束之后，如果 `dp[n-1]` 为 `+∞`，则说明我们无法跳到终点，返回 `-1`，否则返回 `dp[n-1]`。
5. 由于每个位置最多只需要跳跃的次数，因此时间复杂度为 `O(n^2)`。
6. 由于我们需要额外的数组来记录每个位置的最小跳跃次数，因此空间复杂度为 `O(n)`。

**java**

```java

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
```

**python**

```python

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [float("inf")] * n
        dp[0] = 0
        for i in range(1, n):
            for j in range(i):
                if dp[j] != float("inf") and j + nums[j] >= i:
                    dp[i] = dp[j] + 1
                    break
        return dp[n - 1]
```