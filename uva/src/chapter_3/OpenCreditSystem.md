# UVA 11078	Open Credit System

## 题目

给定一个长度为n的整数序列A0,A1,…, An-1，找出两个整数Ai和Aj（i<
j），使得Ai-Aj尽量大。

## 输入格式

输入第一行为数据组数T（T≤20）。每组数据：第一行为整数的个数n（2≤n≤100000）；以下n行，每行为一个绝对值不超过150000的整数。

## 输出格式

对于每组数据，输出Ai-Aj的最大值。

## 思路一

双重循环找`a[i]-a[j]`的最大值。

## 代码

```cpp
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        int max = a[1] - a[0];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] - a[j] > max) {
                    max = a[i] - a[j];
                }
            }
        }
        cout << max << endl;
    }
    return 0;
}
```

## 分析

时间复杂度：O(n^2), 但数据规模是100000，超时。

## 思路二

对于每个数，找到它左边比它下标小的最大值，然后计算`a[i]-a[j]`的最大值。

1. 从1开始左到右遍历数组，维护一个最大值`maxAi`, 表示当前位置左边的最大值, 初始化为`a[0]`。
2. 对于每一个`a[j]`, 计算`a[j]-maxAi`，更新最大值。
3. 然后, 如果`a[j]`大于`maxAi`，则更新`maxAi`。
4. 重复2, 3步骤。

## 代码

```java
public class OpenCreditSystem {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int t, n;
    static int[] arr;

    public static void main(String[] args) {
        t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = input.nextInt();

            int maxAi = arr[0]; // 预设 最大的 a[i] 为 a[0]
            int ans = arr[0] - arr[1]; // 预设 答案为 a[0] - a[1]

            for (int j = 1; j < n; j++) { // 对于每一个a[j], 寻找 i < j, 且 a[i] 最大的数
                ans = Math.max(ans, maxAi - arr[j]);
                maxAi = Math.max(maxAi, arr[j]);
            }

            System.out.println(ans);
        }
    }
}

```

## 分析

时间复杂度：O(n)。

空间复杂度：O(n)。但是, 可以继续优化，只需要维护一个变量`maxAi`，不需要数组`arr`。

## 优化

舍弃数组`arr`，先读取前两个数, 给`maxAi`和`ans`赋初值。
然后, 从第三个数开始读取，更新`maxAi`和`ans`。

```cpp
# include <cstdio>
# include <algorithm> 
using namespace std;

int t, n;

int main() {
	scanf("%d", &t);
	while(t--) {
		int a0, a1;
		scanf("%d", &n);
		scanf("%d%d", &a0, &a1);
		int maxAi = a0, ans = a0 - a1;
		
		for (int i = 2; i < n; i++) {
			int x;
			scanf("%d", &x);
			ans = max(ans, maxAi - x);
			maxAi = max(maxAi, x);
		}
		
		printf("%d\n", ans);
	}	
} 
```