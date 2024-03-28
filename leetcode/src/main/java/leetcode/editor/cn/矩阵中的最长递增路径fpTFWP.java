/**
 * @Title: LCR 112.矩阵中的最长递增路径
 * @TitleSlug: fpTFWP
 * @Author: Neo
 * @Date: 2024-03-28 18:24:45
 */
package leetcode.editor.cn;

public class 矩阵中的最长递增路径fpTFWP {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 矩阵中的最长递增路径fpTFWP().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[] dirs = new int[]{1, 0, -1, 0, 1};
        private int m, n;
        private int[][] matrix, memo;
        
        public int longestIncreasingPath(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            memo = new int[m][n];
            this.matrix = matrix;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, dfs(i, j));
                }
            }
            return ans;
            
        }
        
        private int dfs(int i, int j) {
            if (memo[i][j] != 0) {
                return memo[i][j];
            }
            int res = 1;
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k], y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                    res = Math.max(res, 1 + dfs(x, y));
                }
            }
            return memo[i][j] = res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       