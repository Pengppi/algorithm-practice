/**
 * @Title: 784.字母大小写全排列
 * @TitleSlug: LetterCasePermutation
 * @Author: Neo
 * @Date: 2022-10-30 00:01:08
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 字母大小写全排列().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> letterCasePermutation(String s) {
            List<String> ans = new ArrayList<>();
            dfs(ans, s, -1);
            return ans;
        }

        private void dfs(List<String> ans, String s, int i) {
            if (ans.contains(s)) {
                return;
            }
            ans.add(s);
            char[] cs = s.toCharArray();
            for (int j = i + 1; j < s.length(); j++) {
                if (Character.isUpperCase(cs[j])) {
                    char t = cs[j];
                    cs[j] = Character.toLowerCase(t);
                    dfs(ans, new String(cs), j);
                    cs[j] = t;
                }
                if (Character.isLowerCase(cs[j])) {
                    char t = cs[j];
                    cs[j] = Character.toUpperCase(t);
                    dfs(ans, new String(cs), j);
                    cs[j] = t;
                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
