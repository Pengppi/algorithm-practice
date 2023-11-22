/**
 * @Title: 2304.网格中的最小路径代价
 * @TitleSlug: minimumPathCostInAGrid
 * @Author: Neo
 * @Date: 2023-11-22 09:54:19
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 网格中的最小路径代价 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 网格中的最小路径代价().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n;
        Map<String, Integer> map;

        public int minPathCost(int[][] grid, int[][] moveCost) {
            m = grid.length;
            n = grid[0].length;
            map = new HashMap<>();
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, dfs(grid, 0, i, moveCost));
            }
            return ans;
        }

        private int dfs(int[][] grid, int i, int j, int[][] moveCost) {
            if (i == m - 1) {
                return grid[i][j];
            }
            String key = i + "-" + j;
            if (map.containsKey(key)) {
                return map.get(key);
            }
            int val = grid[i][j];
            int res = Integer.MAX_VALUE;
            for (int k = 0; k < n; k++) {
                res = Math.min(res, dfs(grid, i + 1, k, moveCost) + moveCost[val][k]);
            }
            res += val;
            map.put(key, res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       