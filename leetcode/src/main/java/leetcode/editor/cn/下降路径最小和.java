/**
 * @Title: 931.下降路径最小和
 * @TitleSlug: minimumFallingPathSum
 * @Author: Neo
 * @Date: 2023-07-13 23:43:10
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 下降路径最小和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 下降路径最小和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] matrix, memo;

        public int minFallingPathSum(int[][] matrix) {
            this.matrix = matrix;
            int n = matrix.length;
            memo = new int[n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(memo[i], Integer.MIN_VALUE);

            int ans = Integer.MAX_VALUE;
            for (int c = 0; c < n; c++)
                ans = Math.min(ans, dfs(n - 1, c));
            return ans;
        }

        private int dfs(int r, int c) {
            if (c < 0 || c >= matrix.length) return Integer.MAX_VALUE;
            if (r == 0) return matrix[0][c];
            if (memo[r][c] != Integer.MIN_VALUE) return memo[r][c];
            return memo[r][c] = Math.min(Math.min(
                    dfs(r - 1, c - 1), dfs(r - 1, c)), dfs(r - 1, c + 1)) + matrix[r][c];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       