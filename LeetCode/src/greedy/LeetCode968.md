# LeetCode 968. 监控二叉树

## 题目

给定一个二叉树，我们在树的节点上安装摄像头。

节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

计算监控树的所有节点所需的最小摄像头数量。

**示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/bst_cameras_01.png)

```
输入：[0,0,null,0,0]
输出：1
解释：如图所示，一台摄像头足以监控所有节点。
```

**示例 2：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/bst_cameras_02.png)

```
输入：[0,0,null,0,null,0,null,null,0]
输出：2
解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
```

**提示：**

1. 给定树的节点数的范围是 [1, 1000]。
2. 每个节点的值都是 0。

## 思路

### 1. 贪心算法

我们可以用贪心的思想来解决这个问题。

1. 因为要求最少的摄像头数量，所以我们应该尽可能的让摄像头监控到更多的节点。
2. 所以叶子结点不能放置摄像头，因为在叶子结点放置摄像头，只能监控到叶子结点本身和它的父节点，而不能监控到它的子节点,
   浪费了摄像头的监控范围。
3. 所以我们应该从叶子结点开始，向上安装摄像头，这样可以让摄像头监控到更多的节点。
4. 每个结点有三种状态，0 表示该结点待覆盖，1 表示该结点已经覆盖，2 表示该结点上安装了摄像头。
5. 我们可以用后序遍历的方式，从叶子结点开始，向上安装摄像头，如果当前结点的左右子节点有一个为 0，那么当前结点就需要安装摄像头，
   并且当前结点的状态为 2，如果当前结点的左右子节点有一个为 2，那么当前结点的状态为 1，如果当前结点的左右子节点有一个为 1，
   那么当前结点的状态为 0。
6. 最后，如果根节点的状态为 0，那么根节点也需要安装摄像头，如果根节点的状态为 2，那么根节点不需要安装摄像头，如果根节点的状态为
   1，
   那么根节点的状态为 0。
7. 最后，我们只需要统计出状态为 2 的结点数量，就是我们需要安装的摄像头的数量。

## 实现

**java**

```java
public class Solution {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dfs(root) == 0) {
            res++;
        }
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        if (left == 2 || right == 2) {
            return 1;
        }
        return 0;
    }
}
```

**复杂度分析**

- 时间复杂度：O(n)，n 为二叉树的节点数，需要遍历所有的节点。
- 空间复杂度：O(n)，n 为二叉树的节点数，递归栈的深度最大为 n。

**python**

```python
class Solution:
    def minCameraCover(self, root: TreeNode) -> int:
        self.res = 0

        def dfs(root):
            if not root:
                return 1
            left = dfs(root.left)
            right = dfs(root.right)
            if left == 0 or right == 0:
                self.res += 1
                return 2
            if left == 2 or right == 2:
                return 1
            return 0

        if dfs(root) == 0:
            self.res += 1
        return self.res
```