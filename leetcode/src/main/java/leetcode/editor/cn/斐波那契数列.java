/**
 * @Title: 剑指 Offer 10- I.斐波那契数列
 * @TitleSlug: feiBoNaQiShuLieLcof
 * @Author: Neo
 * @Date: 2023-05-22 22:02:35
 */
package leetcode.editor.cn;

public class 斐波那契数列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 斐波那契数列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }
            long a = 0;
            long b = 1;
            long c = 1;
            int MOD = 1000000007;
            for (int i = 2; i <= n; i++) {
                c = (a + b) % MOD;
                a = b;
                b = c;
            }
            return (int) c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       