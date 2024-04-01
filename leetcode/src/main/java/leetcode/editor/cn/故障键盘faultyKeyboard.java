/**
 * @Title: 2810.故障键盘
 * @TitleSlug: faultyKeyboard
 * @Author: Neo
 * @Date: 2024-04-01 00:34:50
 */
package leetcode.editor.cn;

public class 故障键盘faultyKeyboard {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 故障键盘faultyKeyboard().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String finalString(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == 'i') {
                    sb = sb.reverse();
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       