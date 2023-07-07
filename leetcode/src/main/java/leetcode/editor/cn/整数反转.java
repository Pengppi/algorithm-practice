/**
 * @Title: 7.整数反转
 * @TitleSlug: ReverseInteger
 * @Author: Neo
 * @Date: 2022-10-25 11:01:09
 */
package leetcode.editor.cn;

public class 整数反转 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 整数反转().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int digit = x % 10;
                x /= 10;
                rev = rev * 10 + digit;
            }
            return rev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
