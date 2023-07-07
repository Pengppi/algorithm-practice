/**
 * @Title: 205.同构字符串
 * @TitleSlug: IsomorphicStrings
 * @Author: Neo
 * @Date: 2022-10-27 14:21:59
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 同构字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 同构字符串().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> map = new HashMap<>();

            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                if (map.containsKey(c1)) {
                    if (map.get(c1) != c2) {
                        return false;
                    }
                } else {
                    if (!set.add(c2)) {
                        return false;
                    }
                    map.put(c1, c2);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
