# Codeforces 1042B Vitamins

**链接**: https://codeforces.com/contest/1042/problem/B

## 题目描述

Berland shop sells n
kinds of juices. Each juice has its price ci
. Each juice includes some set of vitamins in it. There are three types of vitamins: vitamin "A", vitamin "B" and
vitamin "C". Each juice can contain one, two or all three types of vitamins in it.

Petya knows that he needs all three types of vitamins to stay healthy. What is the minimum total price of juices that
Petya has to buy to obtain all three vitamins? Petya obtains some vitamin if he buys at least one juice containing it
and drinks it.

## Input

The first line contains a single integer n
(1≤n≤1000)
— the number of juices.

Each of the next n
lines contains an integer ci
(1≤ci≤100000)
and a string si
— the price of the i
-th juice and the vitamins it contains. String si
contains from 1
to 3
characters, and the only possible characters are "A", "B" and "C". It is guaranteed that each letter appears no more
than once in each string si
. The order of letters in strings si
is arbitrary.

## Output

Print -1 if there is no way to obtain all three vitamins. Otherwise print the minimum total price of juices that Petya
has to buy to obtain all three vitamins.

## 思路

1. 状态压缩和背包, 将三种状态压缩为一个状态, 用一个三位二进制数表示三种状态.
    * 只包含`A`的状态为`001`, 只包含`B`的状态为`010`, 只包含`C`的状态为`100`.
    * 三种状态都包含的状态为`111`, 两种状态都包含的状态为`011`, `101`, `110`.
    * 三种状态都不包含的状态为`000`.
2. 用一个`dp`数组表示8种状态, `dp[i]`表示状态为`i`时的最小花费, 初始值为`0x3f3f3f3f`.
3. 遍历每个果汁的价格数组`prices`
4. 对于每个果汁, 枚举八种状态(因为是三位二进制数), 将当前果汁的vitamin含量和枚举的状态取并集代表新的状态,
5. 如果新的状态的花费大于当前状态加上当前果汁的价格, 则更新新状态的花费为当前状态加上当前果汁的价格.
6. 最后返回`dp[7]`即可.

## 代码

```java
public class Vitamins {
    static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    static int n;
    static int[] dp = new int[8];
    static int[] vitamins, prices;

    public static void main(String[] args) {
        n = scanner.nextInt();
        prices = new int[n + 5];
        vitamins = new int[n + 5];
        Arrays.fill(dp, 0x3f3f3f3f); // 0x3f3f3f3f = 1061109567
        dp[0] = 0; // 000, 代表如果没有果汁, 那么花费为0

        for (int i = 1; i <= n; i++) { // 从第一个果汁开始
            prices[i] = scanner.nextInt();

            for (char c : scanner.next().toCharArray()) { // 枚举每个果汁的vitamin
                switch (c) {
                    case 'A': // 001
                        vitamins[i] |= 1;
                        break;
                    case 'B': // 010
                        vitamins[i] |= 2;
                        break;
                    case 'C': // 100
                        vitamins[i] |= 4;
                        break;
                }
            }
        }

        for (int i = 1; i <= n; i++) // 遍历每个果汁
            for (int j = 0; j <= 7; j++) { // 枚举八种状态
                // 如果新的状态的花费大于当前状态加上当前果汁的价格, 则更新新状态的花费为当前状态加上当前果汁的价格
                dp[j | vitamins[i]] = Math.min(dp[j | vitamins[i]], dp[j] + prices[i]);
            }

        // 如果dp[7] == 0x3f3f3f3f, 说明没有果汁能够满足Petya的需求, 输出-1
        // 否则 输出dp[7]
        System.out.println(dp[7] == 0x3f3f3f3f ? -1 : dp[7]);
    }
}
```