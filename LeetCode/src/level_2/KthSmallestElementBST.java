package level_2;

import java.util.Stack;

/**
 * @author ginga
 * @since 25/3/2023 上午9:25
 */
public class KthSmallestElementBST {
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
