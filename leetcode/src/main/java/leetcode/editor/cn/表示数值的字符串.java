/**
 * @Title: 剑指 Offer 20.表示数值的字符串
 * @TitleSlug: biaoShiShuZhiDeZiFuChuanLcof
 * @Author: Neo
 * @Date: 2023-05-13 23:16:53
 */
package leetcode.editor.cn;

import java.time.temporal.Temporal;

public class 表示数值的字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 表示数值的字符串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.trim().length() == 0) {
                return false;
            }
            boolean isNum = false;
            boolean isDot = false;
            boolean e = false;

            char[] cs = s.trim().toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (Character.isDigit(cs[i])) {
                    isNum = true;
                } else if (cs[i] == '.') {
                    if (e || isDot) {
                        return false;
                    }
                    isDot = true;
                } else if (cs[i] == 'e' || cs[i] == 'E') {
                    if (!isNum || e) {
                        return false;
                    }
                    e = true;
                    isNum = false;
                } else if (cs[i] == '-' || cs[i] == '+') {
                    if (i != 0 && cs[i - 1] != 'e' && cs[i - 1] != 'E') {
                        return false;
                    }
                } else {
                    return false;
                }

            }

            return isNum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       