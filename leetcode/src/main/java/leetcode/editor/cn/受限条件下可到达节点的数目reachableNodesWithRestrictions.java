/**
 * @Title: 2368.受限条件下可到达节点的数目
 * @TitleSlug: reachableNodesWithRestrictions
 * @Author: Neo
 * @Date: 2024-03-02 11:45:08
 */
package leetcode.editor.cn;

import java.util.*;

public class 受限条件下可到达节点的数目reachableNodesWithRestrictions {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 受限条件下可到达节点的数目reachableNodesWithRestrictions().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;
        List<Integer>[] g;
        Set<Integer> set = new HashSet<>();
        
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            g = new List[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int[] e : edges) {
                g[e[0]].add(e[1]);
                g[e[1]].add(e[0]);
            }
            Arrays.stream(restricted).forEach(set::add);
            set.add(0);
            dfs(0);
            return ans;
        }
        
        private void dfs(int x) {
            ans++;
            for (int y : g[x]) {
                if (set.add(y)) {
                    dfs(y);
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       