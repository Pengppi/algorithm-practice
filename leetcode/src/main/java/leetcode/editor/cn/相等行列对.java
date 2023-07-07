/**
 * @Title: 2352.相等行列对
 * @TitleSlug: equalRowAndColumnPairs
 * @Author: Neo
 * @Date: 2023-06-06 23:44:34
 */
package leetcode.editor.cn;

public class 相等行列对 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 相等行列对().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            Map<String, Integer> rows = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j != 0) {
                        sb.append("-");
                    }
                    sb.append(grid[i][j]);
                }
                String key = sb.toString();
                rows.put(key, rows.getOrDefault(key, 0) + 1);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j != 0) {
                        sb.append("-");
                    }
                    sb.append(grid[j][i]);
                }
                String key = sb.toString();
                ans += rows.getOrDefault(key, 0);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       