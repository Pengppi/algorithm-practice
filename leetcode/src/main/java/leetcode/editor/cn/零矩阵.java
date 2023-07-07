/**
 * @Title: 面试题 01.08.零矩阵
 * @TitleSlug: ZeroMatrixLcci
 * @Author: Neo
 * @Date: 2022-09-30 15:29:04
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 零矩阵 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 零矩阵().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> col = new HashSet<>();
            Set<Integer> row = new HashSet<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        col.add(j);
                        row.add(i);
                    }
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (col.contains(j) || row.contains(i)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
