/**
 * @Title: 剑指 Offer 14- II.剪绳子 II
 * @TitleSlug: jianShengZiIiLcof
 * @Author: Neo
 * @Date: 2023-05-11 14:55:44
 */
package leetcode.editor.cn;

public class 剪绳子II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 剪绳子II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            if (n <= 3) {
                return n - 1;
            }
            final int MOD = 1_000_000_007;
            long ans = 1;
            while (n > 4) {
                n -= 3;
                ans = ans * 3 % MOD;
            }
            return (int) (ans * n % MOD);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       