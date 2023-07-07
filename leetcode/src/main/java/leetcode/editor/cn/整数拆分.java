/**
 * @Title: 343.整数拆分
 * @TitleSlug: IntegerBreak
 * @Author: Neo
 * @Date: 2022-11-01 14:37:34
 */
package leetcode.editor.cn;

public class 整数拆分 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 整数拆分().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
