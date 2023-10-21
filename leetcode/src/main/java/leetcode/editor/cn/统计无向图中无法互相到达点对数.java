/**
 * @Title: 2316.统计无向图中无法互相到达点对数
 * @TitleSlug: countUnreachablePairsOfNodesInAnUndirectedGraph
 * @Author: Neo
 * @Date: 2023-10-21 13:43:15
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 统计无向图中无法互相到达点对数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 统计无向图中无法互相到达点对数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countPairs(int n, int[][] edges) {
            UF uf = new UF(n);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += n - uf.getSize(uf.find(i));
            }
            return ans / 2;
        }


        class UF {

            int[] parent;
            int[] size;

            public UF(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
                size = new int[n];
                Arrays.fill(size, 1);
            }

            public int find(int x) {
                if (parent[x] == x) {
                    return x;
                } else {
                    return find(parent[x]);
                }
            }

            public void union(int p, int q) {
                int pRoot = find(p);
                int qRoot = find(q);
                if (pRoot != qRoot) {
                    if (size[pRoot] > size[qRoot]) {
                        parent[qRoot] = pRoot;
                        size[pRoot] += size[qRoot];
                    } else {
                        parent[pRoot] = qRoot;
                        size[qRoot] += size[pRoot];
                    }
                }
            }

            public int getSize(int x) {
                return size[x];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       