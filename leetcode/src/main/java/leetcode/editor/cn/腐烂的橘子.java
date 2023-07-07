/**
 * @Title: 994.腐烂的橘子
 * @TitleSlug: rottingOranges
 * @Author: Neo
 * @Date: 2023-07-07 12:20:19
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 腐烂的橘子 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 腐烂的橘子().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            Deque<int[]> d = new ArrayDeque<>();
            int m = grid.length, n = grid[0].length;
            boolean flg = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        d.addLast(new int[]{i, j});
                    } else if (grid[i][j] == 1) {
                        flg = true;
                    }
                }
            }
            if (d.isEmpty()) {
                if (flg) {
                    return -1;
                } else {
                    return 0;
                }
            }
            int[] dirs = new int[]{1, 0, -1, 0, 1};
            int ans = -1;
            while (!d.isEmpty()) {
                for (int i = d.size(); i > 0; i--) {
                    int[] p = d.pollFirst();
                    for (int j = 0; j < 4; j++) {
                        int x = p[0] + dirs[j];
                        if (x < 0 || x >= m) {
                            continue;
                        }
                        int y = p[1] + dirs[j + 1];
                        if (y < 0 || y >= n) {
                            continue;
                        }
                        if (grid[x][y] != 1) {
                            continue;
                        }
                        grid[x][y] = 2;
                        d.addLast(new int[]{x, y});
                    }
                }
                ans++;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       