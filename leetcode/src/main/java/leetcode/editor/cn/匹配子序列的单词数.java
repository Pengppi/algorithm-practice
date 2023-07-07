/**
 * @Title: 792.匹配子序列的单词数
 * @TitleSlug: NumberOfMatchingSubsequences
 * @Author: Neo
 * @Date: 2022-11-17 23:23:38
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 匹配子序列的单词数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 匹配子序列的单词数().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            int n = s.length();
            int cnt = 0;
            HashMap<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                List<Integer> list = map.getOrDefault(c, new ArrayList<>());
                list.add(i);
                map.put(c, list);
            }
            for (String word : words) {
                boolean flg = true;
                int idx = -1;
                for (int i = 0; i < word.length() && flg; i++) {
                    List<Integer> list = map.getOrDefault(word.charAt(i), new ArrayList<>());
                    int l = 0, r = list.size() - 1;
                    while (l < r) {
                        int m = l + r >> 1;
                        if (list.get(m) > idx) {
                            r = m;
                        } else {
                            l = m + 1;
                        }
                    }
                    if (r < 0 || list.get(r) <= idx) {
                        flg = false;
                    } else {
                        idx = list.get(r);
                    }
                }
                if (flg) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
