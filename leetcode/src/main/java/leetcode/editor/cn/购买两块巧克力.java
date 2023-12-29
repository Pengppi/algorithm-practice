/**
 * @Title: 2706.购买两块巧克力
 * @TitleSlug: buyTwoChocolates
 * @Author: Neo
 * @Date: 2023-12-29 00:51:19
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 购买两块巧克力 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 购买两块巧克力().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int buyChoco(int[] prices, int money) {
            Arrays.sort(prices);
            int ans = money - prices[0] - prices[1];
            return ans < 0 ? money : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       