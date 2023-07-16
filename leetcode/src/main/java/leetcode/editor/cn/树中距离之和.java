/**
 * @Title: 834.树中距离之和
 * @TitleSlug: sumOfDistancesInTree
 * @Author: Neo
 * @Date: 2023-07-16 23:46:40
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 树中距离之和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 树中距离之和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer>[] g;
        int[] size;
        int[] ans;

        public int[] sumOfDistancesInTree(int n, int[][] edges) {
            g = new List[n];
            size = new int[n];
            ans = new int[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int[] e : edges) {
                g[e[0]].add(e[1]);
                g[e[1]].add(e[0]);
            }
            dfs(0, -1, 0);
            reroot(0, -1);
            return ans;
        }

        private void dfs(int x, int fa, int dep) {
            ans[0] += dep;
            size[x] = 1;
            for (Integer y : g[x]) {
                if (y != fa) {
                    dfs(y, x, dep + 1);
                    size[x] += size[y];
                }
            }
        }

        private void reroot(int x, int fa) {
            for (Integer y : g[x]) {
                if (y != fa) {
                    ans[y] += ans[x] + g.length - 2 * size[y];
                    reroot(y, x);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       