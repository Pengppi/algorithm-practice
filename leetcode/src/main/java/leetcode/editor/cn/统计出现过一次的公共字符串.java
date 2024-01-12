/**
 * @Title: 2085.统计出现过一次的公共字符串
 * @TitleSlug: countCommonWordsWithOneOccurrence
 * @Author: Neo
 * @Date: 2024-01-12 08:56:23
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 统计出现过一次的公共字符串 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 统计出现过一次的公共字符串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countWords(String[] words1, String[] words2) {
            Set<String> set1 = toMap(words1);
            Set<String> set2 = toMap(words2);
            int ans = 0;
            for (String s : set1) {
                if (set2.contains(s)) {
                    ans++;
                }
            }
            return ans;
        }

        private Set<String> toMap(String[] words) {
            Map<String, Integer> mp = new HashMap<>();
            for (String s : words) {
                mp.put(s, mp.getOrDefault(s, 0) + 1);
            }
            Set<String> set = new HashSet<>();
            for (String s : mp.keySet()) {
                if (mp.get(s) == 1) {
                    set.add(s);
                }
            }
            return set;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       