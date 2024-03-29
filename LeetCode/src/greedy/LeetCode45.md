# LeetCode45. Jump Game II

## 题意

给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。

**示例:**

```text

输入: [2,3,1,1,4]

输出: 2

解释: 跳到最后一个位置的最小跳跃数是 2。
从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
    
```

**说明:**

假设你总是可以到达数组的最后一个位置。

## 题解

### 方法一：贪心

1. 我们可以维护当前能够到达的最大下标位置，记为边界。
2. 我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。
3.
在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。

```java
public int jump(int[]nums){
        int length=nums.length;
        int end=0;
        int maxPosition=0;
        int steps=0;
        for(int i=0;i<length -1;i++){
        maxPosition=Math.max(maxPosition,i+nums[i]);
        if(i==end){
        end=maxPosition;
        steps++;
        }
        }
        return steps;
        }
```

**复杂度分析**

- 时间复杂度：O(n)，其中 n 是数组长度。
- 空间复杂度：O(1)。





