/**
 * @Title: 290.单词规律
 * @TitleSlug: wordPattern
 * @Author: Neo
 * @Date: 2023-12-23 00:29:24
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 单词规律 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 单词规律().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            s = s.trim();
            String[] strs = s.split(" ");
            if (pattern.length() != strs.length) {
                return false;
            }
            Map<Character, String> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < pattern.length(); i++) {
                char k = pattern.charAt(i);
                if (!map.containsKey(k)) {
                    if (!set.add(strs[i])) {
                        return false;
                    }
                    map.put(k, strs[i]);
                } else if (!map.get(k).equals(strs[i])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       