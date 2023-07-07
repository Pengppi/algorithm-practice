/**
 * @Title: 剑指 Offer 63.股票的最大利润
 * @TitleSlug: guPiaoDeZuiDaLiRunLcof
 * @Author: Neo
 * @Date: 2023-05-14 14:16:39
 */
package leetcode.editor.cn;

public class 股票的最大利润 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 股票的最大利润().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n < 2) {
                return 0;
            }
            int ans = 0;
            int mx = prices[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                ans = Math.max(ans, mx - prices[i]);
                mx = Math.max(mx, prices[i]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       