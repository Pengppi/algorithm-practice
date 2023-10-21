/**
 * @Title: 17.电话号码的字母组合
 * @TitleSlug: letterCombinationsOfAPhoneNumber
 * @Author: Neo
 * @Date: 2023-10-21 16:12:10
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 电话号码的字母组合().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return ans;
            }
            dfs(digits.toCharArray(), 0, new StringBuilder());
            return ans;
        }

        private void dfs(char[] cs, int i, StringBuilder s) {
            if (i == cs.length) {
                ans.add(s.toString());
                return;
            }
            int num = cs[i] - '0';
            int from = (num - 2) * 3, to = from + 3;
            if (num == 7) {
                to++;
            }
            if (num == 8) {
                from++;
                to++;
            }
            if (num == 9) {
                from++;
                to = from + 4;
            }
            for (int j = from; j < to; j++) {
                s.append((char) (j + 'a'));
                dfs(cs, i + 1, s);
                s.deleteCharAt(s.length() - 1);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       