/**
 * @Title: 1079.活字印刷
 * @TitleSlug: letterTilePossibilities
 * @Author: Neo
 * @Date: 2023-05-19 15:13:04
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class 活字印刷 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 活字印刷().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Set<Character> set;
        private Map<Character, Integer> map;

        public int numTilePossibilities(String tiles) {
            map = new HashMap<>();
            for (char c : tiles.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            set = new HashSet<>(map.keySet());
            return dfs(tiles.length()) - 1;
        }

        private int dfs(int i) {
            if (i == 0) {
                return 1;
            }
            int res = 1;
            for (char c : set) {
                if (map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                    res += dfs(i - 1);
                    map.put(c, map.get(c) + 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       