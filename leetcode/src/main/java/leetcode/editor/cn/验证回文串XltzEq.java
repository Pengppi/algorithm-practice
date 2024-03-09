/**
 * @Title: LCR 018.验证回文串
 * @TitleSlug: XltzEq
 * @Author: Neo
 * @Date: 2024-03-09 13:01:13
 */
package leetcode.editor.cn;

public class 验证回文串XltzEq {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 验证回文串XltzEq().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int l = 0, r = s.length() - 1;
            while (l < r) {
                while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                    l++;
                }
                while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                    r--;
                }
                if (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        return false;
                    }
                    l++;
                    r--;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       