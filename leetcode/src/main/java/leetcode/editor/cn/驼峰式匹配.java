/**
 * @Title: 1023.驼峰式匹配
 * @TitleSlug: camelcaseMatching
 * @Author: Neo
 * @Date: 2023-04-14 15:15:58
 */
package leetcode.editor.cn;

import java.util.ArrayList;

public class 驼峰式匹配 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 驼峰式匹配().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> ans = new ArrayList<>();
            for (String query : queries) {
                ans.add(isMatch(query, pattern));
            }
            return ans;
        }

        public boolean isMatch(String q, String p) {
            int i = 0, j = 0;

            while (i < q.length() && j < p.length()) {
                if (q.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                } else if (Character.isUpperCase(q.charAt(i))) {
                    return false;
                } else {
                    i++;
                }
            }
            if (j < p.length()) {
                return false;
            }
            if (j == p.length()) {
                while (i < q.length()) {
                    if (Character.isUpperCase(q.charAt(i++))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
