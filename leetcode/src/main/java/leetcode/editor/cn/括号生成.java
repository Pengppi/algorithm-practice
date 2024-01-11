/**
 * @Title: 22.括号生成
 * @TitleSlug: generateParentheses
 * @Author: Neo
 * @Date: 2024-01-10 10:10:39
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 括号生成().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            dfs(ans, new StringBuilder(), n, n);
            return ans;
        }

        private void dfs(List<String> list, StringBuilder sb, int l, int r) {
            if (l == 0 && r == 0) {
                list.add(sb.toString());
                return;
            }
            if (l > 0) {
                sb.append('(');
                dfs(list, sb, l - 1, r);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (r > l) {
                sb.append(')');
                dfs(list, sb, l, r - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       