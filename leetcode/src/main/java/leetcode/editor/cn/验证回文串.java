/**
 * @Title: 125.验证回文串
 * @TitleSlug: validPalindrome
 * @Author: Neo
 * @Date: 2023-12-30 23:36:29
 */
package leetcode.editor.cn;

public class 验证回文串 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 验证回文串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            char[] cs = s.toLowerCase().toCharArray();
            while (l < r) {
                while (l < cs.length && (!Character.isLetter(cs[l]) && !Character.isDigit(cs[l]))) {
                    l++;
                }
                while (r > 0 && (!Character.isLetter(cs[r]) && !Character.isDigit(cs[r]))) {
                    r--;
                }
                if (l < r && cs[l] != cs[r]) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       