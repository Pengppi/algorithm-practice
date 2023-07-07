/**
 * @Title: 剑指 Offer 60.n个骰子的点数
 * @TitleSlug: ngeTouZiDeDianShuLcof
 * @Author: Neo
 * @Date: 2023-07-07 16:18:08
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class N个骰子的点数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new N个骰子的点数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] dicesProbability(int n) {
            int mx = n * 6;
            double[] dp = new double[6];
            Arrays.fill(dp, 1.0 / 6.0);
            for (int i = 2; i <= n; i++) {
                double[] tmp = new double[6 + (i - 1) * 5];
                for (int j = 0; j < dp.length; j++) {
                    for (int k = 0; k < 6; k++) {
                        tmp[j + k] += dp[j] / 6.0;
                    }
                }
                dp = tmp;
            }
            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       