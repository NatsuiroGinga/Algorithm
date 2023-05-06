/**
 * @author ginga
 * @since 29/4/2023 上午10:47
 */
public class LeetCode59 {
    public static void main(String[] args) {
        int n = 4;
        final LeetCode59 leetCode59 = new LeetCode59();
        final int[][] matrix = leetCode59.generateMatrix(n);

        for (int[] row : matrix) {
            for (int v : row) {
                System.out.print(v + "   ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int k = 1;
        int limit = n * n;
        int delta = 0;
        int[][] ans = new int[n][n];

        while (k <= limit) {
            for (int j = delta; j < n - delta; j++)
                ans[delta][j] = k++;

            for (int i = 1 + delta; i < n - delta; i++)
                ans[i][n - 1 - delta] = k++;

            for (int j = n - 2 - delta; j >= delta; j--)
                ans[n - 1 - delta][j] = k++;

            for (int i = n - 2 - delta; i > delta; i--)
                ans[i][delta] = k++;

            delta++;
        }

        return ans;
    }
}
