/**
 * @Title: 1631.最小体力消耗路径
 * @TitleSlug: pathWithMinimumEffort
 * @Author: Neo
 * @Date: 2023-12-11 14:41:49
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 最小体力消耗路径 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最小体力消耗路径().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            int[] dirs = new int[]{1, 0, -1, 0, 1};
            int l = -1, r = (int) 1e6;
            Deque<int[]> queue = new ArrayDeque<>();
            while (l + 1 < r) {
                int mid = l + (r - l) / 2;
                queue.clear();
                queue.offer(new int[]{0, 0});
                boolean[][] vis = new boolean[m][n];
                vis[0][0] = true;
                while (!queue.isEmpty()) {
                    int[] p = queue.poll();
                    int i = p[0], j = p[1];
                    for (int k = 0; k < 4; k++) {
                        int x = i + dirs[k], y = j + dirs[k + 1];
                        if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && Math.abs(heights[x][y] - heights[i][j]) <= mid) {
                            queue.offer(new int[]{x, y});
                            vis[x][y] = true;
                        }
                    }
                    if (vis[m - 1][n - 1]) {
                        break;
                    }
                }
                if (vis[m - 1][n - 1]) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       