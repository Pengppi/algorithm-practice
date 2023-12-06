/**
 * @Title: 2477.到达首都的最少油耗
 * @TitleSlug: minimumFuelCostToReportToTheCapital
 * @Author: Neo
 * @Date: 2023-12-05 14:35:31
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 到达首都的最少油耗 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 到达首都的最少油耗().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private long ans = 0;

        public long minimumFuelCost(int[][] roads, int seats) {
            int n = roads.length + 1;
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int[] e : roads) {
                int x = e[0], y = e[1];
                g[x].add(y);
                g[y].add(x);
            }

            dfs(0, -1, g, seats);
            return ans;
        }

        private int dfs(int x, int fa, List<Integer>[] g, int seats) {
            int sz = 1;
            for (Integer y : g[x]) {
                if (y != fa) {
                    sz += dfs(y, x, g, seats);
                }
            }
            if (x > 0) {
                ans += (sz - 1) / seats + 1;
            }
            return sz;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       