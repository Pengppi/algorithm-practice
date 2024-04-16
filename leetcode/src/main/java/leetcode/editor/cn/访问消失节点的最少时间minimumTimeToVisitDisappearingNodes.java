/**
 * @Title: 3112.访问消失节点的最少时间
 * @TitleSlug: minimumTimeToVisitDisappearingNodes
 * @Author: Neo
 * @Date: 2024-04-16 23:09:00
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 访问消失节点的最少时间minimumTimeToVisitDisappearingNodes {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 访问消失节点的最少时间minimumTimeToVisitDisappearingNodes().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] minimumTime(int n, int[][] edges, int[] disappear) {
            List<int[]>[] g = new List[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int[] e : edges) {
                int x = e[0], y = e[1], wt = e[2];
                g[x].add(new int[]{y, wt});
                g[y].add(new int[]{x, wt});
            }
            
            int[] dis = new int[n];
            Arrays.fill(dis, -1);
            dis[0] = 0;
            
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[]{0, 0});
            
            while (!pq.isEmpty()) {
                int[] p = pq.poll();
                int x = p[0], dx = p[1];
                if (dx > dis[x]) {
                    continue;
                }
                for (int[] q : g[x]) {
                    int y = q[0], dy = q[1] + dx;
                    if (dy < disappear[y] && (dis[y] == -1 || dy < dis[y])) {
                        dis[y] = dy;
                        pq.offer(new int[]{y, dy});
                    }
                }
            }
            return dis;
            
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       