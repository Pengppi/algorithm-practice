/**
 * @Title: 1773.统计匹配检索规则的物品数量
 * @TitleSlug: CountItemsMatchingARule
 * @Author: Neo
 * @Date: 2022-10-29 13:18:18
 */
package leetcode.editor.cn;

import java.util.List;

public class 统计匹配检索规则的物品数量 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 统计匹配检索规则的物品数量().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int cnt = 0;
            int idx = 0;
            if ("color".equals(ruleKey)) {
                idx = 1;
            } else if ("name".equals(ruleKey)) {
                idx = 2;
            }
            for (List<String> item : items) {
                if (item.get(idx).equals(ruleValue)) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
