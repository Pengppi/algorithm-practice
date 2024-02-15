/**
 * @Title: 221.最大正方形
 * @TitleSlug: maximalSquare
 * @Author: Neo
 * @Date: 2024-02-14 14:57:31
 */
package leetcode.editor.cn;

public class 最大正方形 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最大正方形().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m][n];
            int mxLen = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') { 
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        }
                    }
                    mxLen = Math.max(mxLen, dp[i][j]);
                }
            }
            return mxLen * mxLen;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       