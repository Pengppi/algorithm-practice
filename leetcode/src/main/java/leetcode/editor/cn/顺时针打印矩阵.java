/**
 * @Title: 剑指 Offer 29.顺时针打印矩阵
 * @TitleSlug: shunShiZhenDaYinJuZhenLcof
 * @Author: Neo
 * @Date: 2023-05-12 15:05:45
 */
package leetcode.editor.cn;

public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 顺时针打印矩阵().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new int[0];
            }
            int m = matrix.length, n = matrix[0].length;
            int x = 0, y = 0, cur = 0;
            boolean[][] visited = new boolean[m][n];
            int[] ans = new int[m * n];
            int[] dir = {0, 1, 0, -1, 0};
            int k = 0;
            while (cur < m * n) {
                ans[cur++] = matrix[x][y];
                visited[x][y] = true;

                int i = x + dir[k], j = y + dir[k + 1];
                if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || visited[i][j]) {
                    k = (k + 1) % 4;
                }
                x += dir[k];
                y += dir[k + 1];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       