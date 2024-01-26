/**
 * @Title: 2846.边权重均等查询
 * @TitleSlug: minimumEdgeWeightEquilibriumQueriesInATree
 * @Author: Neo
 * @Date: 2024-01-26 09:34:25
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 边权重均等查询 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 边权重均等查询().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] pa;
        private List<int[]>[] g;
        private int[][][] cnt;
        private int[] depth;
        
        public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
            g = new List[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (final int[] e : edges) {
                int x = e[0], y = e[1], w = e[2] - 1;
                g[x].add(new int[]{y, w});
                g[y].add(new int[]{x, w});
            }
            int m = 32 - Integer.numberOfLeadingZeros(n);
            pa = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(pa[i], -1);
            }
            cnt = new int[n][m][26];
            depth = new int[n];
            dfs(0, -1);
            
            for (int i = 0; i < m - 1; i++) {
                for (int x = 0; x < n; x++) {
                    int p = pa[x][i];
                    if (p != -1) {
                        pa[x][i + 1] = pa[p][i];
                        for (int j = 0; j < 26; j++) {
                            cnt[x][i + 1][j] = cnt[x][i][j] + cnt[p][i][j];
                        }
                    }
                }
            }
            
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int x = queries[i][0];
                int y = queries[i][1];
                int pathLen = depth[x] + depth[y];
                if (depth[x] > depth[y]) {
                    int tmp = x;
                    x = y;
                    y = tmp;
                }
                
                int[] cw = new int[26];
                for (int k = depth[y] - depth[x]; k > 0; k &= k - 1) {
                    int z = Integer.numberOfTrailingZeros(k);
                    int p = pa[y][z];
                    for (int j = 0; j < 26; j++) {
                        cw[j] += cnt[y][z][j];
                    }
                    y = p;
                }
                
                if (y != x) {
                    for (int j = m - 1; j >= 0; j--) {
                        int px = pa[x][j];
                        int py = pa[y][j];
                        if (px != py) {
                            for (int k = 0; k < 26; k++) {
                                cw[k] += cnt[x][j][k] + cnt[y][j][k];
                            }
                            x = px;
                            y = py;
                        }
                    }
                    for (int j = 0; j < 26; j++) {
                        cw[j] += cnt[x][0][j] + cnt[y][0][j];
                    }
                    x = pa[x][0];
                }
                
                int lca = x;
                pathLen -= depth[lca] * 2;
                int mxCw = Arrays.stream(cw).max().getAsInt();
                ans[i] = pathLen - mxCw;
            }
            
            return ans;
        }
        
        
        private void dfs(final int x, final int fa) {
            pa[x][0] = fa;
            for (final int[] ints : g[x]) {
                int y = ints[0], w = ints[1];
                if (y != fa) {
                    cnt[y][0][w] = 1;
                    depth[y] = depth[x] + 1;
                    dfs(y, x);
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
        
       