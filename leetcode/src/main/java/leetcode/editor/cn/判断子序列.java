/**
 * @Title: 392.判断子序列
 * @TitleSlug: isSubsequence
 * @Author: Neo
 * @Date: 2023-11-29 13:17:59
 */
package leetcode.editor.cn;

public class 判断子序列 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 判断子序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() > t.length()) {
                return false;
            }
            int i = 0, j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            return i == s.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       