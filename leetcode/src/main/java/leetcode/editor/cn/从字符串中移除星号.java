/**
 * @Title: 2390.从字符串中移除星号
 * @TitleSlug: removingStarsFromAString
 * @Author: Neo
 * @Date: 2023-10-30 14:40:29
 */
package leetcode.editor.cn;

public class 从字符串中移除星号 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 从字符串中移除星号().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeStars(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '*') {
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       