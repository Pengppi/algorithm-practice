/**
 * @Title: 2373.矩阵中的局部最大值
 * @TitleSlug: LargestLocalValuesInAMatrix
 * @Author: Neo
 * @Date: 2023-03-01 18:02:29
 */
package leetcode.editor.cn;

public class 矩阵中的局部最大值 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 矩阵中的局部最大值().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] largestLocal(int[][] grid) {
            int n = grid.length;
            int m = n - 2;
            int[][] res = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    int x = i + 1;
                    int y = j + 1;
                    res[i][j] = find(grid, x, y);
                }
            }
            return res;
        }

        int find(int[][] grid, int x, int y) {
            int mx = grid[x][y];
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    mx = Math.max(mx, grid[i][j]);
                }
            }
            return mx;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
