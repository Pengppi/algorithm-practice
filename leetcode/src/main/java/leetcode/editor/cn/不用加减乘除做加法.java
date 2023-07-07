/**
 * @Title: 剑指 Offer 65.不用加减乘除做加法
 * @TitleSlug: buYongJiaJianChengChuZuoJiaFaLcof
 * @Author: Neo
 * @Date: 2023-05-15 16:58:45
 */
package leetcode.editor.cn;

public class 不用加减乘除做加法 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 不用加减乘除做加法().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {
            while (b != 0) {
                int carry = (a & b) << 1;
                a = a ^ b;
                b = carry;
            }
            return a;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       