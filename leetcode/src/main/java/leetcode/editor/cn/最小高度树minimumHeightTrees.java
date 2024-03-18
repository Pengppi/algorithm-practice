/**
 * @Title: 310.最小高度树
 * @TitleSlug: minimumHeightTrees
 * @Author: Neo
 * @Date: 2024-03-17 13:19:41
 */
package leetcode.editor.cn;

import java.util.*;

public class 最小高度树minimumHeightTrees {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最小高度树minimumHeightTrees().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> ans = new ArrayList<>();
            if (n == 1) {
                ans.add(0);
                return ans;
            }
            List<Integer>[] g = new List[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            int[] degree = new int[n];
            for (int[] e : edges) {
                g[e[0]].add(e[1]);
                g[e[1]].add(e[0]);
                degree[e[0]]++;
                degree[e[1]]++;
            }
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    queue.offer(i);
                }
            }
            int remainNode = n;
            while (remainNode > 2) {
                int sz = queue.size();
                remainNode -= sz;
                for (int i = 0; i < sz; i++) {
                    int t = queue.poll();
                    for (int j : g[t]) {
                        if (--degree[j] == 1) {
                            queue.offer(j);
                        }
                    }
                }
            }
            while (!queue.isEmpty()) {
                ans.add(queue.poll());
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       