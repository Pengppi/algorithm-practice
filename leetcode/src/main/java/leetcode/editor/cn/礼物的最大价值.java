/**
 * @Title: 剑指 Offer 47.礼物的最大价值
 * @TitleSlug: liWuDeZuiDaJieZhiLcof
 * @Author: Neo
 * @Date: 2023-03-08 11:12:08
 */
package leetcode.editor.cn;

public class 礼物的最大价值 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 礼物的最大价值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int j = 1; j < n; j++) {
                dp[0][j] = grid[0][j] + dp[0][j - 1];
            }
            for (int i = 1; i < m; i++) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
