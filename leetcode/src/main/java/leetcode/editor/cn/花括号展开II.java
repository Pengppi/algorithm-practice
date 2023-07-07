/**
 * @Title: 1096.花括号展开 II
 * @TitleSlug: braceExpansionIi
 * @Author: Neo
 * @Date: 2023-04-17 15:39:47
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class 花括号展开II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 花括号展开II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private TreeSet<String> res = new TreeSet<>();

        public List<String> braceExpansionII(String expression) {
            dfs(expression);
            return new ArrayList<>(res);
        }

        private void dfs(String expression) {
            int j = expression.indexOf("}");
            if (j == -1) {
                res.add(expression);
                return;
            }
            int i = expression.lastIndexOf("{", j);
            String prefix = expression.substring(0, i);
            String suffix = expression.substring(j + 1);
            for (String content : expression.substring(i + 1, j).split(",")) {
                dfs(prefix + content + suffix);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

