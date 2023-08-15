//Given a positive integer n, generate an n x n matrix filled with elements 
//from 1 to n² in spiral order. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics Array Matrix Simulation 👍 5801 👎 237


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int cur = 1;
        int delta = 0;
        int[][] matrix = new int[n][n];

        while (cur <= n * n) {
            // 1. 上
            for (int col = delta; col < n - delta; col++) {
                matrix[delta][col] = cur++;
            }

            // 2. 右
            for (int row = delta + 1; row < n - delta; row++) {
                matrix[row][n - delta - 1] = cur++;
            }

            // 3. 下
            for (int col = n - delta - 2; col >= delta; col--) {
                matrix[n - delta - 1][col] = cur++;
            }

            // 4. 左
            for (int row = n - delta - 2; row > delta; row--) {
                matrix[row][delta] = cur++;
            }

            delta++;
        }

        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
