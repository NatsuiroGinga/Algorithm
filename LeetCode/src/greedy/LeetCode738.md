# LeetCode 738. 单调递增的数字

## 题目

给定一个非负整数 `N`，找出小于或等于 `N` 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 `x` 和 `y` 满足 `x <= y` 时，我们称这个整数是单调递增的。）

**示例 1:**

```

输入: N = 10

输出: 9

```

**示例 2:**

```

输入: N = 1234

输出: 1234

```

**示例 3:**

```

输入: N = 332

输出: 299

```

**说明:** `N` 是在 `[0, 10^9]` 范围内的一个整数。

## 思路

### 1. 暴力

1. 我们可以从 `N` 开始，依次判断每个数是否满足题目要求，如果满足，那么就返回当前的数。
2. 如果不满足，那么我们就继续判断下一个数，直到找到满足题目要求的数为止。

**java**

```java

class Solution {

    public int monotoneIncreasingDigits(int N) {
        for (int i = N; i >= 0; i--) {
            if (isMonotoneIncreasingDigits(i)) {
                return i;
            }
        }
        return 0;
    }

    private boolean isMonotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] > chars[i]) {
                return false;
            }
        }
        return true;
    }

}
```

### 2. 贪心算法

我们可以用贪心的思想来解决这个问题。

1. 我们从高位向低位遍历，如果当前位的数字大于下一位的数字，那么我们就把当前位的数字减 1，然后把当前位后面的所有位都变成 9。
2. 如果当前位的数字小于下一位的数字，那么我们就不做任何处理。
3. 最后，我们只需要把处理后的数字转换成整数即可。

**java**

```java

class Solution {

    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < chars.length && chars[i - 1] <= chars[i]) {
            i++;
        }
        if (i < chars.length) {
            while (i > 0 && chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                i--;
            }
            for (i += 1; i < chars.length; i++) {
                chars[i] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }

}
```

**复杂度分析**

- 时间复杂度：O(logN)。我们需要遍历数字 N 的每一位，一共有 O(logN) 位。
- 空间复杂度：O(logN)。我们需要 O(logN) 的空间来存储数字 N 的每一位。

**python**

```python

class Solution:

    def monotoneIncreasingDigits(self, N: int) -> int:
        chars = list(str(N))
        i = 1
        while i < len(chars) and chars[i - 1] <= chars[i]:
            i += 1
        if i < len(chars):
            while i > 0 and chars[i - 1] > chars[i]:
                chars[i - 1] = str(int(chars[i - 1]) - 1)
                i -= 1
            for j in range(i + 1, len(chars)):
                chars[j] = '9'
        return int(''.join(chars))
```
