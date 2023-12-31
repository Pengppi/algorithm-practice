/**
 * @Title: 123.买卖股票的最佳时机 III
 * @TitleSlug: bestTimeToBuyAndSellStockIii
 * @Author: Neo
 * @Date: 2023-10-03 23:40:37
 */
package leetcode.editor.cn;

public class 买卖股票的最佳时机III {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 买卖股票的最佳时机III().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int buy1 = -prices[0], sell1 = 0;
            int buy2 = -prices[0], sell2 = 0;
            for (int i = 1; i < n; i++) {
                buy1 = Math.max(buy1, -prices[i]);
                sell1 = Math.max(sell1, buy1 + prices[i]);
                buy2 = Math.max(buy2, sell1 - prices[i]);
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            return sell2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       