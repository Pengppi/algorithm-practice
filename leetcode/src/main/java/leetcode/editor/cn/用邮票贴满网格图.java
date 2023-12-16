/**
 * @Title: 2132.用邮票贴满网格图
 * @TitleSlug: stampingTheGrid
 * @Author: Neo
 * @Date: 2023-12-14 01:07:43
 */
package leetcode.editor.cn;


public class 用邮票贴满网格图 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 用邮票贴满网格图().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
            int m = grid.length, n = grid[0].length;
            //1. 计算前缀和
            int[][] s = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    s[i + 1][j + 1] = s[i + 1][j] + s[i][j + 1] - s[i][j] + grid[i][j];
                }
            }
            // 2. 计算二维差分
            // 为方便第 3 步的计算，在 d 数组的最上面和最左边各加了一行（列），所以下标要 +1
            int[][] d = new int[m + 2][n + 2];
            for (int i2 = stampHeight; i2 <= m; i2++) {
                for (int j2 = stampWidth; j2 <= n; j2++) {
                    int i1 = i2 - stampHeight;
                    int j1 = j2 - stampWidth;
                    if (s[i2][j2] - s[i2][j1] - s[i1][j2] + s[i1][j1] == 0) {
                        d[i1 + 1][j1 + 1]++;
                        d[i1 + 1][j2 + 1]--;
                        d[i2 + 1][j1 + 1]--;
                        d[i2 + 1][j2 + 1]++;
                    }
                }
            }

            // 3. 还原二维差分矩阵对应的计数矩阵（原地计算）
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] += d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1];
                    if (grid[i - 1][j - 1] == 0 && d[i][j] == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       