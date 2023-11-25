/**
 * @Title: 828.统计子串中的唯一字符
 * @TitleSlug: countUniqueCharactersOfAllSubstringsOfAGivenString
 * @Author: Neo
 * @Date: 2023-11-26 00:25:51
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 统计子串中的唯一字符 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 统计子串中的唯一字符().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniqueLetterString(String s) {
            int ans = 0,n=s.length();
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (!map.containsKey(c)) {
                    map.putIfAbsent(c, new ArrayList<>());
                    map.get(c).add(-1);
                }
                map.get(c).add(i);
            }
            for (Character c : map.keySet()) {
                List<Integer> list = map.get(c);
                list.add(n);
                for (int i = 1; i < list.size() - 1; i++) {
                    int left = list.get(i) - list.get(i - 1);
                    int right = list.get(i + 1) - list.get(i);
                    ans += left * right;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       