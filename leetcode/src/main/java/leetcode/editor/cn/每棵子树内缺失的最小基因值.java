/**
 * @Title: 2003.每棵子树内缺失的最小基因值
 * @TitleSlug: smallestMissingGeneticValueInEachSubtree
 * @Author: Neo
 * @Date: 2023-10-31 10:23:44
 */
package leetcode.editor.cn;

import java.util.*;

public class 每棵子树内缺失的最小基因值 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 每棵子树内缺失的最小基因值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
            int n = parents.length;
            int[] ans = new int[n];
            Arrays.fill(ans, 1);
            int node = -1;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) {
                    node = i;
                    break;
                }
            }
            if (node < 0) {
                return ans;
            }
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 1; i < n; i++) {
                g[parents[i]].add(i);
            }
            Set<Integer> vis = new HashSet<>();
            int genes = 2;
            while (node >= 0) {
                dfs(node, g, vis, nums);
                while (vis.contains(genes)) {
                    genes++;
                }
                ans[node] = genes;
                node = parents[node];
            }
            return ans;
        }

        private void dfs(int node, List<Integer>[] g, Set<Integer> vis, int[] nums) {
            vis.add(nums[node]);
            for (Integer son : g[node]) {
                if (!vis.contains(nums[son])) {
                    dfs(son, g, vis, nums);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       