/**
 * @Title: 49.字母异位词分组
 * @TitleSlug: groupAnagrams
 * @Author: Neo
 * @Date: 2024-01-26 09:37:44
 */
package leetcode.editor.cn;

import java.util.*;

public class 字母异位词分组 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 字母异位词分组().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (final String s : strs) {
                var chars = s.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            }
            ans.addAll(map.values());
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       