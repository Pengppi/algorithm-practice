/**
 * @Title: 3108.带权图里旅途的最小代价
 * @TitleSlug: minimumCostWalkInWeightedGraph
 * @Author: Neo
 * @Date: 2024-04-08 19:39:58
 */
package leetcode.editor.cn;

public class 带权图里旅途的最小代价minimumCostWalkInWeightedGraph {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 带权图里旅途的最小代价minimumCostWalkInWeightedGraph().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] fa, sz, cost;
        
        
        public int[] minimumCost(int n, int[][] edges, int[][] query) {
            initUnionFind(n);
            for (int[] e : edges) {
                union(e[0], e[1], e[2]);
            }
            int[] ans = new int[query.length];
            for (int i = 0; i < query.length; i++) {
                int x = query[i][0], y = query[i][1];
                if (x == y) {
                    continue;
                }
                int rx = find(x), ry = find(y);
                if (rx != ry) {
                    ans[i] = -1;
                } else {
                    ans[i] = cost[rx] == Integer.MAX_VALUE ? 0 : cost[rx];
                }
            }
            return ans;
        }
        
        private void initUnionFind(int n) {
            fa = new int[n];
            sz = new int[n];
            cost = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                sz[i] = 1;
                cost[i] = Integer.MAX_VALUE;
            }
        }
        
        private void union(int x, int y, int w) {
            int rx = find(x), ry = find(y);
            if (rx == ry) {
                cost[rx] &= w;
                return;
            }
            if (sz[rx] < sz[ry]) {
                int t = rx;
                rx = ry;
                ry = t;
            }
            fa[ry] = rx;
            sz[rx] += sz[ry];
            cost[rx] = cost[rx] & cost[ry] & w;
        }
        
        
        private int find(int x) {
            return fa[x] == x ? x : (fa[x] = find(fa[x]));
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       