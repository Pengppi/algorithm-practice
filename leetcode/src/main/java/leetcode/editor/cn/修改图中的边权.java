/**
 * @Title: 2699.修改图中的边权
 * @TitleSlug: modifyGraphEdgeWeights
 * @Author: Neo
 * @Date: 2023-06-09 16:28:44
 */
package leetcode.editor.cn;

import java.util.ArrayList;

public class 修改图中的边权 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 修改图中的边权().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
            List<int[]> g[] = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < edges.length; i++) {
                int x = edges[i][0], y = edges[i][1];
                g[x].add(new int[]{y, i});
                g[y].add(new int[]{x, i});
            }

            int[][] dis = new int[n][2];
            for (int i = 0; i < n; i++) {
                if (i != source) {
                    dis[i][0] = dis[i][1] = Integer.MAX_VALUE;
                }
            }

            dijstra(g, edges, dis, destination, 0, 0);
            int delta = target - dis[destination][0];
            if (delta < 0) {
                return new int[][]{};
            }

            dijstra(g, edges, dis, destination, delta, 1);
            if (dis[destination][1] < target) {
                return new int[][]{};
            }

            for (int[] e : edges) {
                if (e[2] == -1) {
                    e[2] = 1;
                }
            }
            return edges;
        }

        private void dijstra(List<int[]> g[], int[][] edges, int[][] dis, int destination, int delta, int k) {
            int n = g.length;
            boolean[] vis = new boolean[n];
            while (true) {
                int x = -1;
                for (int i = 0; i < n; i++) {
                    if (!vis[i] && (x == -1 || dis[i][k] < dis[x][k])) {
                        x = i;
                    }
                }
                if (x == destination) {
                    return;
                }
                vis[x] = true;
                for (int[] e : g[x]) {
                    int y = e[0], i = e[1];
                    int weight = edges[i][2];
                    if (weight == -1) {
                        weight = 1;
                    }
                    if (k == 1 && edges[i][2] == -1) {
                        int w = delta + dis[y][0] - dis[x][1];
                        if (w > weight) {
                            edges[i][2] = weight = w;
                        }
                    }
                    dis[y][k] = Math.min(dis[y][k], dis[x][k] + weight);
                }
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       