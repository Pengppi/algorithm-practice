/**
 * @Title: 64.最小路径和
 * @TitleSlug: minimumPathSum
 * @Author: Neo
 * @Date: 2024-02-10 11:10:58
 */
package leetcode.editor.cn;

public class 最小路径和 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最小路径和().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] f = new int[m][n];
            f[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                f[i][0] = f[i - 1][0] + grid[i][0];
            }
            for (int j = 1; j < n; j++) {
                f[0][j] = f[0][j - 1] + grid[0][j];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
                }
            }
            return f[m - 1][n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       