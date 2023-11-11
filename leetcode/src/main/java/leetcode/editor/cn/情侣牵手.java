/**
 * @Title: 765.情侣牵手
 * @TitleSlug: couplesHoldingHands
 * @Author: Neo
 * @Date: 2023-11-11 10:55:13
 */
package leetcode.editor.cn;

public class 情侣牵手 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 情侣牵手().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwapsCouples(int[] row) {
            int len = row.length;
            int N = len / 2;
            UnionFind uf = new UnionFind(N);
            for (int i = 0; i < len; i += 2) {
                uf.union(row[i] / 2, row[i + 1] / 2);
            }
            return N - uf.count;
        }


        public class UnionFind {
            int[] parent;
            int count;

            public UnionFind(int n) {
                parent = new int[n];
                count = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                if (x != parent[x]) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y) {
                int rx = find(x);
                int ry = find(y);
                if (rx == ry) {
                    return;
                }
                parent[ry] = rx;
                count--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       