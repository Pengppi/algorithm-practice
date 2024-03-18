/**
 * @Title: 2684.矩阵中移动的最大次数
 * @TitleSlug: maximumNumberOfMovesInAGrid
 * @Author: Neo
 * @Date: 2024-03-16 12:20:10
 */
package leetcode.editor.cn;

public class 矩阵中移动的最大次数maximumNumberOfMovesInAGrid {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 矩阵中移动的最大次数maximumNumberOfMovesInAGrid().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxMoves(int[][] grid) {
            int ans = 0, m = grid.length, n = grid[0].length;
            int[][] f = new int[m][n];
            for (int j = n - 2; j >= 0; j--) {
                for (int i = 0; i < m; i++) {
                    if (grid[i][j] < grid[i][j + 1]) {
                        f[i][j] = 1 + f[i][j + 1];
                    }
                    if (i < m - 1 && grid[i][j] < grid[i + 1][j + 1]) {
                        f[i][j] = Math.max(f[i][j], 1 + f[i + 1][j + 1]);
                    }
                    if (i > 0 && grid[i][j] < grid[i - 1][j + 1]) {
                        f[i][j] = Math.max(f[i][j], 1 + f[i - 1][j + 1]);
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                ans = Math.max(ans, f[i][0]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       