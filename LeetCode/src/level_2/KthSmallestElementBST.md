# LeetCode 230. Kth Smallest Element in a BST

链接: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan&id=level-2

## 题意

给定二叉搜索树的根和一个整数 k，返回树中所有节点值的第 k 个最小值（从1开始）。

## 思路

1. 二叉搜索树的定义: 左子树的所有节点值都小于根节点的值，右子树的所有节点值都大于根节点的值。
2. 中序遍历二叉搜索树，得到的序列是升序的。
3. 用栈迭代得中序遍历二叉搜索树, 同时计数, 第k个节点时直接返回值

## 代码

```java
class Solution {
    static Stack<TreeNode> stack = new Stack<>();

    public int kthSmallest(TreeNode root, int k) {
        stack.push(root);

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (k-- == 1) {
                return root.val;
            }
            root = root.right;
        }

        return 0;
    }
}
```