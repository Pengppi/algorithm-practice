/**
 * @Title: 54.螺旋矩阵
 * @TitleSlug: spiralMatrix
 * @Author: Neo
 * @Date: 2024-01-16 23:52:52
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 螺旋矩阵().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            final int m = matrix.length, n = matrix[0].length;
            List<Integer> list = new ArrayList<>();
            var dirs = new int[]{0, 1, 0, -1, 0};
            int i = 0, j = -1, k = 0;
            while (list.size() < m * n) {
                int x = i + dirs[k], y = j + dirs[k + 1];
                while (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == -200) {
                    k = (k + 1) % 4;
                    x = i + dirs[k];
                    y = j + dirs[k + 1];
                }
                j = y;
                list.add(matrix[i][j]);
                matrix[i][j] = -200;
            }
            return list;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       