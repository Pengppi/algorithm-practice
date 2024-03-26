/**
 * @Title: 2642.设计可以求最短路径的图类
 * @TitleSlug: designGraphWithShortestPathCalculator
 * @Author: Neo
 * @Date: 2024-03-26 00:05:54
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 设计可以求最短路径的图类designGraphWithShortestPathCalculator {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 设计可以求最短路径的图类designGraphWithShortestPathCalculator().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Graph {
        private final int INF = Integer.MAX_VALUE / 3;
        private final int[][] f;
        
        public Graph(int n, int[][] edges) {
            f = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(f[i], INF);
                f[i][i] = 0;
            }
            for (int[] e : edges) {
                int x = e[0], y = e[1], z = e[2];
                f[x][y] = z;
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (f[i][k] == INF) {
                        continue;
                    }
                    for (int j = 0; j < n; j++) {
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);
                    }
                }
            }
        }
        
        public void addEdge(int[] edge) {
            int x = edge[0], y = edge[1], z = edge[2];
            if (z >= f[x][y]) {
                return;
            }
            int n = f.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[i][j] = Math.min(f[i][j], f[i][x] + z + f[y][j]);
                }
            }
        }
        
        public int shortestPath(int node1, int node2) {
            return f[node1][node2] >= INF ? -1 : f[node1][node2];
        }
    }

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       