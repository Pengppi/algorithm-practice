/**
 * @Title: 1768.交替合并字符串
 * @TitleSlug: MergeStringsAlternately
 * @Author: Neo
 * @Date: 2022-10-23 13:18:39
 */
package leetcode.editor.cn;

public class 交替合并字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 交替合并字符串().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < word1.length() || i < word2.length()) {
                if (i < word1.length()) {
                    sb.append(word1.charAt(i));
                }
                if (i < word2.length()) {
                    sb.append(word2.charAt(i));
                }
                i++;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
