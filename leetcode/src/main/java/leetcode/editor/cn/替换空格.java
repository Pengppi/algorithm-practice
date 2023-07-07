/**
 * @Title: 剑指 Offer 05.替换空格
 * @TitleSlug: tiHuanKongGeLcof
 * @Author: Neo
 * @Date: 2023-04-27 14:04:48
 */
package leetcode.editor.cn;

public class 替换空格 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 替换空格().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       