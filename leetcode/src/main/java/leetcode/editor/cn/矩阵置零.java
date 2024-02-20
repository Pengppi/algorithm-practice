/**
 * @Title: 73.矩阵置零
 * @TitleSlug: setMatrixZeroes
 * @Author: Neo
 * @Date: 2024-02-20 22:06:13
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 矩阵置零 {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 矩阵置零().new Solution();
        solution.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean row0 = false, col0 = false;
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    col0 = true;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    row0 = true;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (row0) {
                Arrays.fill(matrix[0], 0);
            }
            if (col0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       