/**
 * @Title: LCR 107.01 矩阵
 * @TitleSlug: twoBCMpM
 * @Author: Neo
 * @Date: 2024-03-24 16:57:24
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class Zero1矩阵twoBCMpM {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new Zero1矩阵twoBCMpM().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[][] ans = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(ans[i], Integer.MAX_VALUE / 2);
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        if (i > 0) {
                            ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
                        }
                        if (j > 0) {
                            ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
                        }
                    } else {
                        ans[i][j] = 0;
                    }
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (mat[i][j] == 1) {
                        if (i < m - 1) {
                            ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
                        }
                        if (j < n - 1) {
                            ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
                        }
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       