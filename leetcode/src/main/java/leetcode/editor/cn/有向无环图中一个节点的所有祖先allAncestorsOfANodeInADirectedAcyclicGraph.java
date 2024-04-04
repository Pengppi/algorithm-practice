/**
 * @Title: 2192.有向无环图中一个节点的所有祖先
 * @TitleSlug: allAncestorsOfANodeInADirectedAcyclicGraph
 * @Author: Neo
 * @Date: 2024-04-04 00:12:47
 */
package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class 有向无环图中一个节点的所有祖先allAncestorsOfANodeInADirectedAcyclicGraph {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 有向无环图中一个节点的所有祖先allAncestorsOfANodeInADirectedAcyclicGraph().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            List<Integer>[] g = new List[n];
            Set<Integer>[] res = new Set[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            Arrays.setAll(res, i -> new TreeSet<>());
            int[] in = new int[n];
            for (int[] e : edges) {
                g[e[0]].add(e[1]);
                in[e[1]]++;
            }
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (in[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int x = queue.poll();
                for (int y : g[x]) {
                    res[y].addAll(res[x]);
                    res[y].add(x);
                    if (--in[y] == 0) {
                        queue.offer(y);
                    }
                }
            }
            return Arrays.stream(res).map(ArrayList::new).collect(Collectors.toList());
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       