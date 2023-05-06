# LeetCode347. 前 K 个频繁元素

## 题目

给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

```
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
```

示例 2:

```
输入: nums = [1], k = 1
输出: [1]
```

说明：

- 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
- 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
- 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
- 你可以按任意顺序返回答案。

## 解题思路

### 方法一：堆

1. 首先遍历一遍数组，用哈希表记录每个数字出现的次数。
2. 遍历哈希表，用一个大小为 k 的小顶堆，统计频率最大的 k 个数。首先将前 k 个数插入小顶堆中，随后从第 k+1
   个数开始遍历，如果当前遍历到的数的频率比小顶堆的堆顶的数的频率要大，则弹出堆顶的数，将当前遍历到的数的值插入堆中。最终，小顶堆中的
   k 个数即为前 k 个高频元素。
3. 最后，我们将前 k 个高频元素添加到返回值中并返回。
4. 时间复杂度：O(nlogk)，其中 n 是数组的长度。我们首先遍历原数组，并使用哈希表记录出现次数，每个元素需要 O(1) 的时间，共需 O(
   n) 的时间。随后，我们遍历「出现次数数组」，由于堆的大小至多为 k，因此每次堆操作需要 O(logk) 的时间，共需 O(nlogk) 的时间。二者之和为
   O(nlogk)。
5. 空间复杂度：O(n)，其中 n 是数组的长度。主要为哈希表的开销。

**代码**

```python

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # 统计每个数字出现的次数
        count = collections.Counter(nums)
        # 小顶堆
        heap = []
        # 遍历哈希表
        for key, value in count.items():
            # 如果堆的大小小于k，直接插入堆中
            if len(heap) < k:
                heapq.heappush(heap, (value, key))
            # 否则，如果当前元素的频率大于堆顶元素的频率，则弹出堆顶元素，将当前元素插入堆中
            elif value > heap[0][0]:
                heapq.heappop(heap)
                heapq.heappush(heap, (value, key))
        # 遍历完成后，堆中的元素即为前k个高频元素
        res = []
        for _ in range(k):
            res.append(heapq.heappop(heap)[1])
        return res[::-1]
```

### 方法二：桶排序

1. 首先遍历一遍数组，用哈希表记录每个数字出现的次数。
2. 创建一个数组，将出现次数作为数组下标，对于出现次数不同的数字集合，存入对应的数组下标。
3. 最后，从后向前遍历数组，取出前 k 个数字。
4. 时间复杂度：O(n)，其中 n 是数组的长度。我们首先遍历原数组，并使用哈希表记录出现次数，每个元素需要 O(1) 的时间，共需 O(n)
   的时间。随后，我们遍历「出现次数数组」，由于不同的出现次数的元素可能相同，因此将「出现次数数组」中的元素放入哈希表中，以便统计不同出现次数元素的个数，最后遍历哈希表，从后向前遍历哈希表，找出前
   k 个元素，这里使用了「基数排序」，遍历哈希表的时间复杂度为 O(n)，基数排序的时间复杂度为 O(n)，因此总时间复杂度为 O(n)。
5. 空间复杂度：O(n)，其中 n 是数组的长度。主要为哈希表的开销。

**代码**

```python

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # 统计每个数字出现的次数
        count = collections.Counter(nums)
        # 桶排序
        bucket = [[] for _ in range(len(nums) + 1)]
        for key, value in count.items():
            bucket[value].append(key)
        # 从后向前遍历桶
        res = []
        for i in range(len(bucket) - 1, -1, -1):
            if bucket[i]:
                res.extend(bucket[i])
            if len(res) >= k:
                break
        return res[:k]
```