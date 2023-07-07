/**
 * @Title: 14.最长公共前缀
 * @TitleSlug: LongestCommonPrefix
 * @Author: Neo
 * @Date: 2022-10-23 13:32:15
 */
package leetcode.editor.cn;

public class 最长公共前缀 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最长公共前缀().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            int e = 0;
            boolean flg = true;
            while (flg) {
                for (int i = 0; i < strs.length; i++) {
                    if (e >= strs[i].length() || (strs[i].charAt(e) != strs[0].charAt(e))) {
                        flg = false;
                        e--;
                        break;
                    }
                }
                e++;
            }
            return strs[0].substring(0, e);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
