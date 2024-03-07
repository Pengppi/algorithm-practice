/**
 * @Title: 1976.到达目的地的方案数
 * @TitleSlug: numberOfWaysToArriveAtDestination
 * @Author: Neo
 * @Date: 2024-03-05 14:32:12
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 到达目的地的方案数numberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 到达目的地的方案数numberOfWaysToArriveAtDestination().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPaths(int n, int[][] roads) {
            final int MOD = 1_000_000_007;
            long[][] g = new long[n][n];
            for (long[] row : g) {
                Arrays.fill(row, Long.MAX_VALUE / 2);
            }
            for (int[] road : roads) {
                int x = road[0], y = road[1], d = road[2];
                g[x][y] = g[y][x] = d;
            }
            long[] dist = new long[n];
            Arrays.fill(dist, 1, n, Long.MAX_VALUE / 2);
            int[] f = new int[n];
            f[0] = 1;
            boolean[] vis = new boolean[n];
            while (true) {
                int x = -1;
                for (int i = 0; i < n; i++) {
                    if (!vis[i] && (x < 0 || dist[i] < dist[x])) {
                        x = i;
                    }
                }
                if (x == n - 1) {
                    return f[n - 1];
                }
                vis[x] = true;
                for (int y = 0; y < n; y++) {
                    long newDist = dist[x] + g[x][y];
                    if (newDist < dist[y]) {
                        dist[y] = newDist;
                        f[y] = f[x];
                    } else if (newDist == dist[y]) {
                        f[y] = (f[y] + f[x]) % MOD;
                    }
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       