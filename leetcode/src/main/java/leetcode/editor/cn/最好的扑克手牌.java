/**
 * @Title: 2347.最好的扑克手牌
 * @TitleSlug: BestPokerHand
 * @Author: Neo
 * @Date: 2023-02-20 10:23:26
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最好的扑克手牌 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最好的扑克手牌().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String bestHand(int[] ranks, char[] suits) {
            String[] res = new String[]{"Flush", "Three of a Kind", "Pair", "High Card"};
            Set<Character> s = new HashSet<>();
            Map<Integer, Integer> r = new HashMap<>();
            for (int i = 0; i < 5; i++) {
                s.add(suits[i]);
                r.put(ranks[i], r.getOrDefault(ranks[i], 0) + 1);
            }
            if (s.size() == 1) {
                return res[0];
            }
            if (r.size() == 5) {
                return res[3];
            }
            for (Integer key : r.keySet()) {
                if (r.get(key) >= 3) {
                    return res[1];
                }
            }
            return res[2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
