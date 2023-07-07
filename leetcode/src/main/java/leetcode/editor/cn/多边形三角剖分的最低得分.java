/**
 * @Title: 1039.多边形三角剖分的最低得分
 * @TitleSlug: minimumScoreTriangulationOfPolygon
 * @Author: Neo
 * @Date: 2023-04-02 00:31:35
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 多边形三角剖分的最低得分 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 多边形三角剖分的最低得分().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] v;
        int[][] visted;

        public int minScoreTriangulation(int[] values) {
            v = values;
            int n = v.length;
            visted = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(visted[i], -1);
            }
            return dfs(0, n - 1);
        }

        public int dfs(int i, int j) {
            if (j == i + 1) {
                return 0;
            }
            if (visted[i][j] != -1) {
                return visted[i][j];
            }
            int res = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                res = Math.min(res, (dfs(i, k) + dfs(k, j) + v[i] * v[k] * v[j]));
            }
            visted[i][j] = res;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
