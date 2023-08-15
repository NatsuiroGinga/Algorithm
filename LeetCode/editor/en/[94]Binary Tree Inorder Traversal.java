//Given the root of a binary tree, return the inorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [1,3,2]
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
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively?
//
// Related Topics Stack Tree Depth-First Search Binary Tree 👍 11986 👎 619


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.isEmpty()) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            ans.add(root.val);
            root = root.right;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
