/**
 * @Title: 934.最短的桥
 * @TitleSlug: ShortestBridge
 * @Author: Neo
 * @Date: 2022-10-25 09:54:24
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 最短的桥 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最短的桥().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Deque<int[]> d = new ArrayDeque<>();
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int shortestBridge(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                boolean seen = false;
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j);
                        seen = true;
                        break;
                    }

                }
                if (seen) {
                    break;
                }
            }
            int ans = 0;
            while (!d.isEmpty()) {
                int t[] = d.poll();
                int i = t[0], j = t[1];
                int step = grid[i][j];
                for (int k = 0; k < dirs.length; k++) {
                    int x = i + dirs[k][0];
                    int y = j + dirs[k][1];
                    if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return step - 2;
                    }
                    if (grid[x][y] == 0) {
                        grid[x][y] = step + 1;
                        d.offer(new int[]{x, y});
                    }
                }
            }
            return -1;
        }

        private void dfs(int[][] grid, int i, int j) {
            d.offer(new int[]{i, j});
            grid[i][j] = 2;
            for (int k = 0; k < dirs.length; k++) {
                int nx = i + dirs[k][0], ny = j + dirs[k][1];
                if (nx >= grid.length || nx < 0 || ny >= grid[0].length || ny < 0 || grid[nx][ny] != 1) {
                    continue;
                }
                dfs(grid, nx, ny);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
