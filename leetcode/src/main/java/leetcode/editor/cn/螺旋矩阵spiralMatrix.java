/**
 * @Title: 54.螺旋矩阵
 * @TitleSlug: spiralMatrix
 * @Author: Neo
 * @Date: 2024-04-28 22:20:39
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵spiralMatrix {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 螺旋矩阵spiralMatrix().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int m = matrix.length, n = matrix[0].length;
            int[] dir = {0, 1, 0, -1, 0};
            int x = 0, y = 0, d = 0;
            boolean[][] vis = new boolean[m][n];
            for (int i = 0; i < m * n; i++) {
                ans.add(matrix[x][y]);
                vis[x][y] = true;
                int a = x + dir[d], b = y + dir[d + 1];
                if (a < 0 || a >= m || b < 0 || b >= n || vis[a][b]) {
                    d = (d + 1) % 4;
                    a = x + dir[d];
                    b = y + dir[d + 1];
                }
                x = a;
                y = b;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       