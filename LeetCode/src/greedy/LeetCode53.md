# LeetCode53 最大子序和

## 题目描述

给定一个整数数组 `nums` ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

**示例:**

```text

输入: [-2,1,-3,4,-1,2,1,-5,4],

输出: 6

解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

```

**进阶:**

如果你已经实现复杂度为 O(*n*) 的解法，尝试使用更为精妙的分治法求解。

## 题解

### 方法一：动态规划

1. 状态定义：设动态规划列表 `dp` ，`dp[i]` 代表以元素 `nums[i]` 为结尾的连续子数组最大和。
2. 转移方程：若 `dp[i-1] ≤ 0` ，说明 `dp[i - 1]` 对 `dp[i]` 产生负贡献，即 `dp[i-1] + nums[i]` 还不如 `nums[i]` 本身大。
    - 当 `dp[i - 1] > 0` 时：执行 `dp[i] = dp[i-1] + nums[i]` ；
    - 当 `dp[i - 1] ≤ 0` 时：执行 `dp[i] = nums[i]` ；
3. 初始状态： `dp[0] = nums[0]` ，即以 `nums[0]` 结尾的连续子数组最大和为 `nums[0]` 。
4. 返回值：返回 `dp` 列表中的最大值，代表全局最大值。

```java

public int maxSubArray(int[]nums){
        int pre=0,maxAns=nums[0];
        for(int x:nums){
        pre=Math.max(pre+x,x);
        maxAns=Math.max(maxAns,pre);
        }
        return maxAns;
        }

```

**复杂度分析**

- 时间复杂度：O(n)，其中 n 为 nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
- 空间复杂度：O(1)。我们只需要常数空间存放若干变量。

### 方法二：分治

1. 将数组从中间分成左右两部分，那么最大子序列和的位置只有三种情况：
    - 完全位于左边数组；
    - 完全位于右边数组；
    - 跨越中点，左右部分都有一部分。
2. 情况 1 和情况 2 可以递归求解，情况 3 的最大和可以通过求出前半部分的最大和（包含前半部分的最后一个元素）以及后半部分的最大和（包含后半部分的第一个元素）相加而得到。
3. 求出三种情况的最大值即可。

```java

public int maxSubArray(int[]nums){
        return get(nums,0,nums.length-1).mSum;
        }

public Status get(int[]a,int l,int r){
        if(l==r){
        return new Status(a[l],a[l],a[l],a[l]);
        }
        int m=(l+r)>>1;
        Status lSub=get(a,l,m);
        Status rSub=get(a,m+1,r);
        return pushUp(lSub,rSub);
        }

public Status pushUp(Status l,Status r){
        int iSum=l.iSum+r.iSum;
        int lSum=Math.max(l.lSum,l.iSum+r.lSum);
        int rSum=Math.max(r.rSum,r.iSum+l.rSum);
        int mSum=Math.max(Math.max(l.mSum,r.mSum),l.rSum+r.lSum);
        return new Status(lSum,rSum,mSum,iSum);
        }

class Status {
    int lSum, rSum, mSum, iSum;

    public Status(int lSum, int rSum, int mSum, int iSum) {
        this.lSum = lSum;
        this.rSum = rSum;
        this.mSum = mSum;
        this.iSum = iSum;
    }
}

```

**复杂度分析**

- 时间复杂度：O(n)，其中 n 为 nums 数组的长度。分治法的递推函数 T(n) = 2 \* T(n/2) + O(1)。
- 空间复杂度：O(logn)，其中 n 为 nums 数组的长度。递归深度为 O(logn)。

### 方法三：贪心

1. 从头开始遍历数组，用 `curSum` 记录当前元素位置的累加和，用 `maxSum` 记录全局最大和。
2. 如果 `curSum > 0` ，说明 `curSum` 对结果有增益效果，则 `curSum` 保留并加上当前遍历数字；
3. 如果 `curSum ≤ 0` ，说明 `curSum` 对结果无增益效果，需要舍弃，则 `curSum` 直接更新为当前遍历数字；
4. 每次比较 `curSum` 和 `maxSum`的大小，将最大值置为 `maxSum` ，遍历结束返回结果。

```java

public int maxSubArray(int[]nums){
        int curSum=0,maxSum=nums[0];
        for(int num:nums){
        curSum=Math.max(num,curSum+num);
        maxSum=Math.max(maxSum,curSum);
        }
        return maxSum;
        }

```
