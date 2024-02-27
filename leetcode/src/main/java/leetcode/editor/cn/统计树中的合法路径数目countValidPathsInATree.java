/**
 * @Title: 2867.统计树中的合法路径数目
 * @TitleSlug: countValidPathsInATree
 * @Author: Neo
 * @Date: 2024-02-27 21:50:40
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 统计树中的合法路径数目countValidPathsInATree {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 统计树中的合法路径数目countValidPathsInATree().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MX = 100001;
        private static boolean notPrime[] = new boolean[MX];
        
        static {
            notPrime[1] = true;
            for (int i = 2; i * i < MX; i++) {
                if (!notPrime[i]) {
                    for (int j = i * i; j < MX; j += i) {
                        notPrime[j] = true;
                    }
                }
            }
        }
        
        public long countPaths(int n, int[][] edges) {
            List<Integer>[] g = new List[n + 1];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int[] e : edges) {
                int x = e[0], y = e[1];
                g[x].add(y);
                g[y].add(x);
            }
            long ans = 0;
            int[] size = new int[n + 1];
            List<Integer> nodes = new ArrayList<>();
            for (int x = 1; x <= n; x++) {
                if (notPrime[x]) {
                    continue;
                }
                int sum = 0;
                for (int y : g[x]) {
                    if (!notPrime[y]) {
                        continue;
                    }
                    if (size[y] == 0) {
                        nodes.clear();
                        dfs(y, -1, g, nodes);
                        for (int z : nodes) {
                            size[z] = nodes.size();
                        }
                    }
                    ans += (long) size[y] * sum;
                    sum += size[y];
                }
                ans += sum;
            }
            return ans;
        }
        
        private void dfs(int x, int fa, List<Integer>[] g, List<Integer> nodes) {
            nodes.add(x);
            for (int y : g[x]) {
                if (y != fa && notPrime[y]) {
                    dfs(y, x, g, nodes);
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       