/**
 * @Title: 200.岛屿数量
 * @TitleSlug: numberOfIslands
 * @Author: Neo
 * @Date: 2024-01-03 08:56:43
 */
package leetcode.editor.cn;

public class 岛屿数量 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 岛屿数量().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        ++ans;
                    }
                }
            }
            return ans;
        }

        int[] dirs = new int[]{1, 0, -1, 0, 1};

        private void dfs(char[][] grid, int i, int j) {
            grid[i][j] = 0;
            int m = grid.length, n = grid[0].length;
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                    dfs(grid, x, y);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       