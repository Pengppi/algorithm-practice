/**
 * @Title: 1139.最大的以 1 为边界的正方形
 * @TitleSlug: Largest1BorderedSquare
 * @Author: Neo
 * @Date: 2023-02-17 11:13:56
 */
package leetcode.editor.cn;

public class 最大的以1为边界的正方形 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最大的以1为边界的正方形().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            int[][][] dp = new int[m + 1][n + 1][2];
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (grid[i - 1][j - 1] == 1) {
                        dp[i][j][0] = dp[i][j - 1][0] + 1;
                        dp[i][j][1] = dp[i - 1][j][1] + 1;
                        int len = Math.min(dp[i][j][0], dp[i][j][1]);
                        for (int k = len; k > res; k--) {
                            if (dp[i - k + 1][j][0] >= k && dp[i][j - k + 1][1] >= k) {
                                res = k;
                                break;
                            }
                        }
                    }
                }
            }
            return res * res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
