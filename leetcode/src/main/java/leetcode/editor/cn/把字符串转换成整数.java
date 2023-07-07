/**
 * @Title: 剑指 Offer 67.把字符串转换成整数
 * @TitleSlug: baZiFuChuanZhuanHuanChengZhengShuLcof
 * @Author: Neo
 * @Date: 2023-05-01 14:49:21
 */
package leetcode.editor.cn;

public class 把字符串转换成整数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 把字符串转换成整数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strToInt(String str) {
            boolean isFirst = true;
            boolean isNegative = false;
            long ans = 0;
            for (char c : str.toCharArray()) {
                if (isFirst) {
                    if (c == ' ') {
                        continue;
                    }
                    if (c == '-') {
                        isNegative = true;
                        isFirst = false;
                        continue;
                    }
                    if (c == '+') {
                        isFirst = false;
                        continue;
                    }
                    if (c >= '0' && c <= '9') {
                        isFirst = false;
                        ans = ans * 10 + (c - '0');
                        continue;
                    }
                    return 0;
                }
                if (!Character.isDigit(c)) {
                    break;
                }
                ans = ans * 10 + (c - '0');
                if (ans > Integer.MAX_VALUE) {
                    break;
                }
            }
            if (isNegative) {
                ans = -ans;
            }
            if (ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       