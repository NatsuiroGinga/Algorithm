//Given the root of a binary tree, return all root-to-leaf paths in any order. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,5]
//Output: ["1->2->5","1->3"]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: ["1"]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics String Backtracking Tree Depth-First Search Binary Tree 👍 600
//0 👎 257


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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        dfs(ans, new LinkedList<Integer>(), root);
        return ans;
    }

    private void dfs(List<String> ans, List<Integer> list, TreeNode root) {
        list.add(root.val);

        if (root.left == null && root.right == null) {
            ans.add(strconv(list));
            return;
        }
        
        if (root.left != null) {
            dfs(ans, list, root.left);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            dfs(ans, list, root.right);
            list.remove(list.size() - 1);
        }

    }

    private String strconv(List<Integer> list) {
        if (list.isEmpty()) return "";

        StringBuilder sb = new StringBuilder(2 * list.size());
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append("->").append(list.get(i));
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
