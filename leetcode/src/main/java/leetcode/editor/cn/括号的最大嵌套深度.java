/**
 * @Title: 1614.括号的最大嵌套深度
 * @TitleSlug: maximumNestingDepthOfTheParentheses
 * @Author: Neo
 * @Date: 2023-07-07 11:43:45
 */
package leetcode.editor.cn;

public class 括号的最大嵌套深度 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 括号的最大嵌套深度().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDepth(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            int l = 0;
            int ans = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    l++;
                } else if (c == ')') {
                    l--;
                }
                ans = Math.max(ans, l);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       