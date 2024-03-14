/**
 * @Title: LCR 116.省份数量
 * @TitleSlug: bLyHh0
 * @Author: Neo
 * @Date: 2024-03-14 09:16:15
 */
package leetcode.editor.cn;

public class 省份数量bLyHh0 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 省份数量bLyHh0().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.count;
        }
        
        private class UnionFind {
            int count;
            int[] fa;
            int[] sz;
            
            public UnionFind(int n) {
                count = n;
                fa = new int[n];
                sz = new int[n];
                for (int i = 0; i < n; i++) {
                    fa[i] = i;
                    sz[i] = 1;
                }
            }
            
            public int find(int x) {
                return fa[x] == x ? x : (fa[x] = find(fa[x]));
            }
            
            public void union(int x, int y) {
                int fx = find(x);
                int fy = find(y);
                if (fx == fy) {
                    return;
                }
                if (sz[fx] < sz[fy]) {
                    int temp = fx;
                    fx = fy;
                    fy = temp;
                }
                fa[fy] = fx;
                sz[fx] += sz[fy];
                count--;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       