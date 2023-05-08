package greedy;

import level_2.TreeNode;

/**
 * @author ginga
 * @since 6/5/2023 下午2:07
 */
public class LeetCode968 {
    private int result;

    public int minCameraCover(TreeNode root) {
        return postorder(root) == 0 ? result + 1 : result;
    }

    private int postorder(TreeNode cur) {
        if (cur == null) {
            return 2;
        }

        int left = postorder(cur.left);
        int right = postorder(cur.right);

        // 左右都覆盖
        if (left == 2 && right == 2) {
            return 0;
        }

        // 左右至少有一个没覆盖
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }

        // 左右至少一个有摄像头
        if (left == 1 || right == 1) {
            return 2;
        }

        return -1;
    }
}
