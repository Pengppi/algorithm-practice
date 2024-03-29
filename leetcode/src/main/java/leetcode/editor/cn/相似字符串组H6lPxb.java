/**
 * @Title: LCR 117.相似字符串组
 * @TitleSlug: H6lPxb
 * @Author: Neo
 * @Date: 2024-03-29 11:02:48
 */
package leetcode.editor.cn;

public class 相似字符串组H6lPxb {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 相似字符串组H6lPxb().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSimilarGroups(String[] strs) {
            int n = strs.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (uf.find(i) == uf.find(j)) {
                        continue;
                    }
                    if (isValid(strs[i], strs[j])) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.tot;
        }
        
        private boolean isValid(String s1, String s2) {
            int diff = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (++diff > 2) {
                        return false;
                    }
                }
            }
            return true;
        }
        
        private class UnionFind {
            int[] fa;
            int[] sz;
            int tot;
            
            
            public UnionFind(int n) {
                fa = new int[n];
                sz = new int[n];
                tot = n;
                for (int i = 0; i < n; i++) {
                    fa[i] = i;
                    sz[i] = 1;
                }
            }
            
            public void union(int x, int y) {
                int fx = find(x), fy = find(y);
                if (fx == fy) {
                    return;
                }
                if (sz[fx] < sz[fy]) {
                    int temp = fx;
                    fx = fy;
                    fy = temp;
                }
                sz[fx] += sz[fy];
                fa[fy] = fx;
                tot--;
            }
            
            public int find(int x) {
                return fa[x] == x ? x : (fa[x] = find(fa[x]));
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       