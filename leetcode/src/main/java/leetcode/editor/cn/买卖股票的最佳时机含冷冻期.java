/**
 * @Title: 309.买卖股票的最佳时机含冷冻期
 * @TitleSlug: bestTimeToBuyAndSellStockWithCooldown
 * @Author: Neo
 * @Date: 2023-10-05 23:07:56
 */
package leetcode.editor.cn;

public class 买卖股票的最佳时机含冷冻期 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 买卖股票的最佳时机含冷冻期().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n == 1) {
                return 0;
            }
            int[][] f = new int[n][2];
            f[0][1] = -prices[0];
            f[1][1] = Math.max(f[0][1], f[0][0] - prices[1]);
            f[1][0] = Math.max(f[0][0], f[1][1] + prices[1]);
            for (int i = 2; i < n; i++) {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]);
                f[i][1] = Math.max(f[i - 1][1], f[i - 2][0] - prices[i]);
            }
            return f[n - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       