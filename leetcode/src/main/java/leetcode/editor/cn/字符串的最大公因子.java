/**
 * @Title: 1071.字符串的最大公因子
 * @TitleSlug: greatestCommonDivisorOfStrings
 * @Author: Neo
 * @Date: 2023-10-13 15:50:24
 */
package leetcode.editor.cn;

public class 字符串的最大公因子 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 字符串的最大公因子().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            String t = str1.substring(0, gcd(str1.length(), str2.length()));
            if (check(t, str1) && check(t, str2)) {
                return t;
            }
            return "";
        }

        private boolean check(String t, String str) {
            int k = str.length() / t.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(t);
            }
            return sb.toString().equals(str);
        }


        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       