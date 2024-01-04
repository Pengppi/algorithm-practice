/**
 * @Title: 2397.被列覆盖的最多行数
 * @TitleSlug: maximumRowsCoveredByColumns
 * @Author: Neo
 * @Date: 2024-01-04 08:50:24
 */
package leetcode.editor.cn;

public class 被列覆盖的最多行数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 被列覆盖的最多行数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumRows(int[][] matrix, int numSelect) {
            int m = matrix.length, n = matrix[0].length;
            int[] rows = new int[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        rows[i] |= 1 << j;
                    }
                }
            }
            int ans = 0;
            for (int i = (1 << n) - 1; i >= 0; i--) {
                if (Integer.bitCount(i) != numSelect) {
                    continue;
                }
                int cnt = 0;
                for (int j = 0; j < m; j++) {
                    if ((rows[j] & i) == rows[j]) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       