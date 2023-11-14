/**
 * @Title: 1334.阈值距离内邻居最少的城市
 * @TitleSlug: findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance
 * @Author: Neo
 * @Date: 2023-11-14 14:35:39
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 阈值距离内邻居最少的城市 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 阈值距离内邻居最少的城市().new Solution();
        solution.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] g = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(g[i], Integer.MAX_VALUE / 2);
            }
            for (int[] e : edges) {
                int x = e[0], y = e[1];
                g[x][y] = e[2];
                g[y][x] = e[2];
            }
            int[][][] memo = new int[n][n][n];
            int ans = 0, mx = n;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j && dfs(n - 1, i, j, g, memo) <= distanceThreshold) {
                        cnt++;
                    }
                }
                if (cnt <= mx) {
                    mx = cnt;
                    ans = i;
                }
            }
            return ans;
        }

        private int dfs(int k, int i, int j, int[][] g, int[][][] memo) {
            if (k < 0) {
                return g[i][j];
            }
            if (memo[k][i][j] != 0) {
                return memo[k][i][j];
            }
            memo[k][i][j] = memo[k][j][i] = Math.min(dfs(k - 1, i, j, g, memo), dfs(k - 1, i, k, g, memo) + dfs(k - 1, k, j, g, memo));
            return memo[k][i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       