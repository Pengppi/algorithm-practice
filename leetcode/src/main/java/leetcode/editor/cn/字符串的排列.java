/**
 * @Title: 剑指 Offer 38.字符串的排列
 * @TitleSlug: ziFuChuanDePaiLieLcof
 * @Author: Neo
 * @Date: 2023-05-28 14:19:52
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class 字符串的排列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 字符串的排列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, Integer> map = new HashMap<>();
        int len;

        public String[] permutation(String s) {
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            len = s.length();
            List<String> res = new ArrayList<>();
            dfs(res, "");
            String[] ans = new String[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }

        private void dfs(List<String> res, String s) {
            if (s.length() == len) {
                res.add(s);
                return;
            }
            for (Character c : map.keySet()) {
                if (map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                    dfs(res, s + c);
                    map.put(c, map.get(c) + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       