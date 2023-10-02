/**
 * @Title: 122.买卖股票的最佳时机 II
 * @TitleSlug: bestTimeToBuyAndSellStockIi
 * @Author: Neo
 * @Date: 2023-10-02 23:55:07
 */
package leetcode.editor.cn;

public class 买卖股票的最佳时机II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 买卖股票的最佳时机II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp[][] = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       