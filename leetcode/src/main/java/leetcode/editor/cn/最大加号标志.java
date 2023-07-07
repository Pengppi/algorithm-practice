/**
 * @Title: 764.最大加号标志
 * @TitleSlug: LargestPlusSign
 * @Author: Neo
 * @Date: 2022-11-09 10:27:57
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 最大加号标志 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最大加号标志().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(grid[i], 1);
            }
            for (int[] mine : mines) {
                int x = mine[0];
                int y = mine[1];
                grid[x][y] = 0;
            }
            int[][] l = new int[n][n];
            int[][] r = new int[n][n];
            int[][] u = new int[n][n];
            int[][] d = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int k = n - 1 - j;
                    if (j == 0) {
                        l[i][j] = grid[i][j] == 1 ? 1 : 0;
                        r[i][k] = grid[i][k] == 1 ? 1 : 0;
                    } else {
                        l[i][j] = grid[i][j] == 1 ? 1 + l[i][j - 1] : 0;
                        r[i][k] = grid[i][k] == 1 ? 1 + r[i][k + 1] : 0;
                    }
                }
                for (int j = 0; j <n; j++) {
                    int k = n - 1 - j;
                    if (j == 0) {
                        u[j][i] = grid[j][i] == 1 ? 1 : 0;
                        d[k][i] = grid[k][i] == 1 ? 1 : 0;
                    } else {
                        u[j][i] = grid[j][i] == 1 ? 1 + u[j - 1][i] : 0;
                        d[k][i] = grid[k][i] == 1 ? 1 + d[k + 1][i] : 0;
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int ud = Math.min(u[i][j], d[i][j]);
                    int lr = Math.min(l[i][j], r[i][j]);
                    int k = Math.min(ud, lr);
                    ans = Math.max(ans, k);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
