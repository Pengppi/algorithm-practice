/**
 * @Title: 2603.收集树中金币
 * @TitleSlug: collectCoinsInATree
 * @Author: Neo
 * @Date: 2023-10-15 14:42:13
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 收集树中金币 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 收集树中金币().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int collectTheCoins(int[] coins, int[][] edges) {
            int n = coins.length;
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            int[] link = new int[n];
            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                link[x]++;
                link[y]++;
                g[x].add(y);
                g[y].add(x);
            }
            int totEdge = n - 1;
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (link[i] == 1 && coins[i] == 0) {
                    queue.add(i);
                    link[i]--;
                }
            }
            while (!queue.isEmpty()) {
                int leaf = queue.poll();
                totEdge--;
                for (Integer fa : g[leaf]) {
                    if (--link[fa] == 1 && coins[fa] == 0) {
                        queue.add(fa);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (link[i] == 1 && coins[i] == 1) {
                    queue.add(i);
                }
            }
            totEdge -= queue.size();
            for (Integer x : queue) {
                for (Integer fa : g[x]) {
                    if (--link[fa] == 1) {
                        totEdge--;
                    }
                }
            }
            return Math.max(totEdge * 2, 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       