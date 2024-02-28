/**
 * @Title: 1388.3n 块披萨
 * @TitleSlug: pizzaWith3nSlices
 * @Author: Neo
 * @Date: 2024-02-28 21:37:48
 */
package leetcode.editor.cn;

public class ThreeN块披萨pizzaWith3nSlices {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new ThreeN块披萨pizzaWith3nSlices().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSizeSlices(int[] slices) {
            int n = slices.length;
            int m = n / 3;
            int[] slices1 = new int[n - 1];
            int[] slices2 = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                slices1[i] = slices[i];// 考虑第一个数，则放弃最后一个树
                slices2[i] = slices[i + 1];// 考虑最后一个数，则放弃第一个数
            }
            return Math.max(maxSize(slices1, m), maxSize(slices2, m));
        }
        
        
        private int maxSize(int[] slices, int m) {
            int n = slices.length;
            // dp[i][j] 表示前 i+1 个数中选 j 个不相邻数的最大和
            int[][] dp = new int[n][m + 1];
            dp[0][1] = slices[0];
            dp[1][1] = Math.max(slices[0], slices[1]);
            for (int i = 2; i < n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + slices[i]);
                }
            }
            return dp[n - 1][m];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       