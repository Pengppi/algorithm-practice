/**
 * @Title: 2312.卖木头块
 * @TitleSlug: sellingPiecesOfWood
 * @Author: Neo
 * @Date: 2024-03-15 18:54:54
 */
package leetcode.editor.cn;

public class 卖木头块sellingPiecesOfWood {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 卖木头块sellingPiecesOfWood().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long sellingWood(int m, int n, int[][] prices) {
            long[][] f = new long[m + 1][n + 1];
            for (int[] p : prices) {
                f[p[0]][p[1]] = p[2];
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int k = 0; k <= i / 2; k++) {
                        f[i][j] = Math.max(f[i][j], f[i - k][j] + f[k][j]);
                    }
                    for (int k = 0; k <= j / 2; k++) {
                        f[i][j] = Math.max(f[i][j], f[i][j - k] + f[i][k]);
                    }
                }
            }
            return f[m][n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       