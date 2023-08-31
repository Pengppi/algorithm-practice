/**
 * @Title: 1761.一个图中连通三元组的最小度数
 * @TitleSlug: minimumDegreeOfAConnectedTrioInAGraph
 * @Author: Neo
 * @Date: 2023-08-31 10:57:14
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 一个图中连通三元组的最小度数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 一个图中连通三元组的最小度数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minTrioDegree(int n, int[][] edges) {
            int[] degrees = new int[n];
            for (int[] edge : edges) {
                int x = edge[0] - 1, y = edge[1] - 1;
                degrees[x]++;
                degrees[y]++;
            }
            Integer[] sortedNode = new Integer[n];
            for (int i = 0; i < n; i++) {
                sortedNode[i] = i;
            }
            Arrays.sort(sortedNode, (a, b) -> degrees[a] - degrees[b]);
            Arrays.sort(degrees);
            int[] newNodeId = new int[n];
            for (int i = 0; i < n; ++i) {
                newNodeId[sortedNode[i]] = i;
            }
            boolean[][] isConnected = new boolean[n][n];

            for (int[] edge : edges) {
                int u = newNodeId[edge[0] - 1], v = newNodeId[edge[1] - 1];
                isConnected[v][u] = true;
                isConnected[u][v] = true;
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                if (degrees[i] * 3 >= result) {
                    break;
                }
                for (int j = i + 1; j < n; ++j) {
                    if (!isConnected[i][j]) {
                        continue;
                    }
                    if (degrees[i] + degrees[j] * 2 >= result) {
                        break;
                    }
                    for (int k = j + 1; k < n; ++k) {
                        int count = degrees[i] + degrees[j] + degrees[k];
                        if (count >= result) {
                            break;
                        }
                        if (isConnected[i][k] && isConnected[j][k]) {
                            result = count;
                        }
                    }
                }
            }
            return result == Integer.MAX_VALUE ? -1 : result - 6;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       