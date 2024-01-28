/**
 * @Title: 2861.最大合金数
 * @TitleSlug: maximumNumberOfAlloys
 * @Author: Neo
 * @Date: 2024-01-27 11:09:29
 */
package leetcode.editor.cn;

import java.util.List;

public class 最大合金数 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最大合金数().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
            int l = 0, r = 2_0000_0001;
            while (l + 1 < r) {
                int m = (l + r) / 2;
                if (getCost(m, composition, stock, cost) <= budget) {
                    l = m;
                } else {
                    r = m;
                }
            }
            return l;
        }
        
        private long getCost(final int x, final List<List<Integer>> composition, final List<Integer> stock, final List<Integer> cost) {
            long mnCost = Integer.MAX_VALUE;
            for (final List<Integer> comp : composition) {
                long curCost = 0;
                for (int i = 0; i < comp.size(); i++) {
                    curCost += Math.max((long) comp.get(i) * x - stock.get(i), 0) * cost.get(i);
                }
                mnCost = Math.min(mnCost, curCost);
            }
            return mnCost;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       