/**
 * @Title: 1163.按字典序排在最后的子串
 * @TitleSlug: lastSubstringInLexicographicalOrder
 * @Author: Neo
 * @Date: 2023-04-24 22:17:23
 */
package leetcode.editor.cn;

public class 按字典序排在最后的子串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 按字典序排在最后的子串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String lastSubstring(String s) {
            int n = s.length();
            int i = 0, j = 1, k = 0;
            while (j + k < n) {
                if (s.charAt(i + k) == s.charAt(j + k)) {
                    k++;
                    continue;
                }
                if (s.charAt(i + k) > s.charAt(j + k)) {
                    j = j + k + 1;
                } else {
                    i = Math.max(i + k + 1, j);
                    j = i + 1;
                }
                k = 0;
            }
            return s.substring(i);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       