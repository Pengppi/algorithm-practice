/**
 * @Title: 714.买卖股票的最佳时机含手续费
 * @TitleSlug: bestTimeToBuyAndSellStockWithTransactionFee
 * @Author: Neo
 * @Date: 2023-10-06 23:41:58
 */
package leetcode.editor.cn;

public class 买卖股票的最佳时机含手续费 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 买卖股票的最佳时机含手续费().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] f = new int[n][2];
            f[0][1] = -prices[0] - fee;
            for (int i = 1; i < n; i++) {
                f[i][0] = Math.max(f[i - 1][0], prices[i] + f[i - 1][1]);
                f[i][1] = Math.max(f[i - 1][1], f[i][0] - prices[i] - fee);
            }
            return f[n - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       