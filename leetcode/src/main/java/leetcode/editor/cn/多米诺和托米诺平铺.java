/**
 * @Title: 790.多米诺和托米诺平铺
 * @TitleSlug: DominoAndTrominoTiling
 * @Author: Neo
 * @Date: 2022-11-12 10:47:25
 */
package leetcode.editor.cn;

public class 多米诺和托米诺平铺 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 多米诺和托米诺平铺().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTilings(int n) {
            if (n == 1) {
                return 1;
            }
            long MOD = (long) 1e9 + 7;
            long f[] = new long[n + 1];
            f[0] = 1;
            f[1] = 1;
            f[2] = 2;
            for (int i = 3; i <= n; i++) {
                f[i] = (f[i - 1] * 2 + f[i - 3]) % MOD;
            }
            return (int) f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
