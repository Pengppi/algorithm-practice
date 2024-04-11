/**
 * @Title: 1766.互质树
 * @TitleSlug: treeOfCoprimes
 * @Author: Neo
 * @Date: 2024-04-11 00:28:31
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 互质树treeOfCoprimes {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 互质树treeOfCoprimes().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static List<Integer>[] gcds = new List[51];
        
        static {
            Arrays.setAll(gcds, i -> new ArrayList<Integer>());
            for (int i = 1; i < 51; i++) {
                for (int j = 1; j < 51; j++) {
                    if (gcd(i, j) == 1) {
                        gcds[i].add(j);
                        gcds[j].add(i);
                    }
                }
            }
        }
        
        private List<Integer>[] fa = new List[51], g;
        private int[] depth, ans;
        
        private static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
        
        public int[] getCoprimes(int[] nums, int[][] edges) {
            int n = nums.length;
            g = new List[n];
            depth = new int[n];
            ans = new int[n];
            Arrays.fill(ans, -1);
            Arrays.fill(depth, -1);
            Arrays.setAll(g, e -> new ArrayList<Integer>());
            Arrays.setAll(fa, e -> new ArrayList<Integer>());
            for (int[] e : edges) {
                g[e[0]].add(e[1]);
                g[e[1]].add(e[0]);
            }
            dfs(nums, 0, 1);
            return ans;
        }
        
        private void dfs(int[] nums, int x, int dep) {
            depth[x] = dep;
            for (int num : gcds[nums[x]]) {
                if (!fa[num].isEmpty()) {
                    int y = fa[num].get(fa[num].size() - 1);
                    if (ans[x] == -1 || depth[y] > depth[ans[x]]) {
                        ans[x] = y;
                    }
                }
            }
            fa[nums[x]].add(x);
            for (int y : g[x]) {
                if (depth[y] == -1) {
                    dfs(nums, y, dep + 1);
                }
            }
            fa[nums[x]].remove(fa[nums[x]].size() - 1);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       