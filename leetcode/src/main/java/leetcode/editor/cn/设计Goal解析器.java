/**
 * @Title: 1678.设计 Goal 解析器
 * @TitleSlug: GoalParserInterpretation
 * @Author: Neo
 * @Date: 2022-11-06 17:05:20
 */
package leetcode.editor.cn;

public class 设计Goal解析器 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 设计Goal解析器().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String interpret(String command) {
            StringBuilder sb = new StringBuilder();
            char[] cs = command.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == '(') {
                    if (cs[i + 1] == ')') {
                        sb.append("o");
                        i++;
                    } else if (cs[i + 1] == 'a') {
                        sb.append("al");
                        i += 3;
                    }
                } else {
                    sb.append("G");
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
