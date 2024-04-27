/**
 * @Title: 2639.查询网格图中每一列的宽度
 * @TitleSlug: findTheWidthOfColumnsOfAGrid
 * @Author: Neo
 * @Date: 2024-04-27 13:10:58
 */
package leetcode.editor.cn;

public class 查询网格图中每一列的宽度findTheWidthOfColumnsOfAGrid {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 查询网格图中每一列的宽度findTheWidthOfColumnsOfAGrid().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findColumnWidth(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] ans = new int[n];
            for (int j = 0; j < n; j++) {
                int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    mx = Math.max(mx, grid[i][j]);
                    mn = Math.min(mn, grid[i][j]);
                }
                ans[j] = Math.max(getLen(mx), getLen(mn));
            }
            return ans;
        }
        
        private int getLen(int num) {
            int len = 0;
            if (num == 0) {
                return 1;
            } else if (num < 0) {
                len = 1;
                num = -num;
            }
            while (num > 0) {
                len++;
                num /= 10;
            }
            return len;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       