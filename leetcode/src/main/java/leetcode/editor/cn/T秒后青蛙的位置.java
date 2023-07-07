/**
 * @Title: 1377.T 秒后青蛙的位置
 * @TitleSlug: frogPositionAfterTSeconds
 * @Author: Neo
 * @Date: 2023-05-24 14:38:19
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class T秒后青蛙的位置 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new T秒后青蛙的位置().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double frogPosition(int n, int[][] edges, int t, int target) {
            List<Integer>[] graph = new List[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            graph[1].add(0);
            for (int[] e : edges) {
                int x = e[0], y = e[1];
                graph[x].add(y);
                graph[y].add(x);
            }
            long ans = dfs(graph, target, 1, 0, t);
            return ans == 0 ? 0 : 1.0 / ans;
        }

        private long dfs(List<Integer>[] g, int target, int x, int fa, int time) {
            if (time == 0) {
                return x == target ? 1 : 0;
            }
            if (x == target) {
                return g[x].size() == 1 ? 1 : 0;
            }
            for (int y : g[x]) {
                if (y != fa) {
                    long ans = dfs(g, target, y, x, time - 1);
                    if (ans != 0) {
                        return ans * (g[x].size() - 1);
                    }
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       