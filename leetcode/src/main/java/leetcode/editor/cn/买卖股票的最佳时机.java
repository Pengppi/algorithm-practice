/**
 * @Title: 121.买卖股票的最佳时机
 * @TitleSlug: bestTimeToBuyAndSellStock
 * @Author: Neo
 * @Date: 2023-10-10 22:31:01
 */
package leetcode.editor.cn;

public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 买卖股票的最佳时机().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int mn = prices[0];
            int ans = 0;
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, prices[i] - mn);
                mn = Math.min(mn, prices[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       