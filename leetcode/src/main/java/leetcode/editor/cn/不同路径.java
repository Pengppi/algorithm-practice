/**
 * @Title: 62.不同路径
 * @TitleSlug: uniquePaths
 * @Author: Neo
 * @Date: 2023-11-02 10:35:34
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 不同路径 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 不同路径().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] f = new int[m ][n];
            Arrays.fill(f[0], 1);
            for (int i = 0; i < m; i++) {
                f[i][0] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    f[i][j] = f[i][j - 1] + f[i - 1][j];
                }
            }
            return f[m-1][n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       