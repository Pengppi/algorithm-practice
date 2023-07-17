/**
 * @Title: 415.字符串相加
 * @TitleSlug: addStrings
 * @Author: Neo
 * @Date: 2023-07-17 23:55:41
 */
package leetcode.editor.cn;

public class 字符串相加 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 字符串相加().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            int i = num1.length() - 1, j = num2.length() - 1;
            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) {
                    sum += num1.charAt(i--) - '0';
                }
                if (j >= 0) {
                    sum += num2.charAt(j--) - '0';
                }
                sb.append(sum % 10);
                carry = sum / 10;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       