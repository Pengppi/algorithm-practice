/**
 * @Title: 1329.将矩阵按对角线排序
 * @TitleSlug: sortTheMatrixDiagonally
 * @Author: Neo
 * @Date: 2024-04-29 00:07:51
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 将矩阵按对角线排序sortTheMatrixDiagonally {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 将矩阵按对角线排序sortTheMatrixDiagonally().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int m, n;
        
        public int[][] diagonalSort(int[][] mat) {
            m = mat.length;
            n = mat[0].length;
            for (int i = 0; i < m; i++) {
                sort(mat, i, 0);
            }
            for (int j = 1; j < n; j++) {
                sort(mat, 0, j);
            }
            return mat;
        }
        
        private void sort(int[][] mat, int x, int y) {
            List<Integer> list = new ArrayList<>();
            int i = x, j = y;
            while (i < m && j < n) {
                list.add(mat[i++][j++]);
            }
            list.sort(Integer::compareTo);
            for (int num : list) {
                mat[x++][y++] = num;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       