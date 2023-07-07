/**
 * @Title: 2697.字典序最小回文串
 * @TitleSlug: lexicographicallySmallestPalindrome
 * @Author: Neo
 * @Date: 2023-06-09 17:37:46
 */
package leetcode.editor.cn;

public class 字典序最小回文串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 字典序最小回文串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String makeSmallestPalindrome(String s) {
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length / 2; i++) {
                int j = cs.length - 1 - i;
                if (cs[i] == cs[j]) {
                    continue;
                }
                if (cs[i] < cs[j]) {
                    cs[j] = cs[i];
                } else {
                    cs[i] = cs[j];
                }
            }
            return new String(cs);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       