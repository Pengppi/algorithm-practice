/**
 * @Title: 74.搜索二维矩阵
 * @TitleSlug: searchA2dMatrix
 * @Author: Neo
 * @Date: 2024-04-02 01:21:05
 */
package leetcode.editor.cn;

public class 搜索二维矩阵searchA2dMatrix {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 搜索二维矩阵searchA2dMatrix().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] mat;
        private int m, n;
        
        public boolean searchMatrix(int[][] matrix, int target) {
            m = matrix.length;
            n = matrix[0].length;
            mat = matrix;
            int l = -1, r = m * n;
            while (l + 1 < r) {
                int mid = l + ((r - l) >> 1);
                if (getMid(mid) < target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            return r < m * n && getMid(r) == target;
        }
        
        private int getMid(int mid) {
            return mat[mid / n][mid % n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       