/**
 * @Title: 剑指 Offer 10- II.青蛙跳台阶问题
 * @TitleSlug: qingWaTiaoTaiJieWenTiLcof
 * @Author: Neo
 * @Date: 2023-04-29 13:53:02
 */
package leetcode.editor.cn;

public class 青蛙跳台阶问题 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 青蛙跳台阶问题().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n) {
            int MOD = 1000000007;
            int a = 1, b = 1;
            for (int i = 2; i <= n; i++) {
                int c = (a + b) % MOD;
                a = b;
                b = c;
            }
            return b;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       