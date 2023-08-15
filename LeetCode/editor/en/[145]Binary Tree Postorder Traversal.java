//Given the root of a binary tree, return the postorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [3,2,1]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively?
//
// Related Topics Stack Tree Depth-First Search Binary Tree 👍 6226 👎 178


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<Integer> list = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                list.addFirst(root.val);
                root = root.right;
            }
            root = st.pop();
            root = root.left;
        }

        return new LinkedList(list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
