/**
 * @Title: 剑指 Offer 16.数值的整数次方
 * @TitleSlug: shuZhiDeZhengShuCiFangLcof
 * @Author: Neo
 * @Date: 2023-04-27 14:08:29
 */
package leetcode.editor.cn;

public class 数值的整数次方 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数值的整数次方().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            double res = 1;
            long m = n;
            if (m < 0) {
                x = 1 / x;
                m = -m;
            }
            while (m > 0) {
                if ((m & 1) == 1) {
                    res *= x;
                }
                m = m >> 1;
                x *= x;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       