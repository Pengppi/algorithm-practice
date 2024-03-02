/**
 * @Title: 2581.统计可能的树根数目
 * @TitleSlug: countNumberOfPossibleRootNodes
 * @Author: Neo
 * @Date: 2024-02-29 23:04:39
 */
package leetcode.editor.cn;

import java.util.*;

public class 统计可能的树根数目countNumberOfPossibleRootNodes {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 统计可能的树根数目countNumberOfPossibleRootNodes().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;
        Set<Long> set;
        List<Integer>[] g;
        int cnt = 0;// 以0为根的树所猜中的数量
        int k;
        
        public int rootCount(int[][] edges, int[][] guesses, int k) {
            int n = edges.length;
            set = new HashSet();
            g = new List[n + 1];
            this.k = k;
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int[] e : edges) {
                int x = e[0], y = e[1];
                g[x].add(y);
                g[y].add(x);
            }
            for (int[] guess : guesses) {
                int x = guess[0], y = guess[1];
                set.add((long) x << 32 | y);
            }
            dfs(0, -1);
            reRootDfs(0, -1, cnt);
            return ans;
        }
        
        private void dfs(int x, int fa) {
            for (int y : g[x]) {
                if (y != fa) {
                    if (set.contains((long) x << 32 | y)) {
                        cnt++;
                    }
                    dfs(y, x);
                }
            }
        }
        
        private void reRootDfs(int x, int fa, int count) {
            if (count >= k) {
                ans++;
            }
            for (int y : g[x]) {
                if (y != fa) {
                    int c = count;
                    if (set.contains((long) x << 32 | y)) {
                        c--;
                    }
                    if (set.contains((long) y << 32 | x)) {
                        c++;
                    }
                    reRootDfs(y, x, c);
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       