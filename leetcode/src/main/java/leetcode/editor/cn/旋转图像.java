/**
 * @Title: 48.旋转图像
 * @TitleSlug: rotateImage
 * @Author: Neo
 * @Date: 2024-01-21 23:25:57
 */
package leetcode.editor.cn;

public class 旋转图像 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 旋转图像().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1 2 3    1 4 7    7 4 1
        // 4 5 6 => 2 5 8 => 8 5 2
        // 7 8 9    3 6 9    9 6 3
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    swap(matrix, i, j, j, i);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    swap(matrix, i, j, i, n - 1 - j);
                }
            }
        }
        
        private void swap(final int[][] matrix, final int a, final int b, final int c, final int d) {
            int tmp = matrix[a][b];
            matrix[a][b] = matrix[c][d];
            matrix[c][d] = tmp;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       