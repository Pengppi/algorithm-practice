/**
 * @Title: 1926.迷宫中离入口最近的出口
 * @TitleSlug: nearestExitFromEntranceInMaze
 * @Author: Neo
 * @Date: 2023-10-30 14:40:37
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 迷宫中离入口最近的出口 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 迷宫中离入口最近的出口().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nearestExit(char[][] maze, int[] entrance) {
            int m = maze.length, n = maze[0].length;
            Deque<int[]> d = new ArrayDeque<>();
            d.offer(new int[]{entrance[0], entrance[1]});
            int[] dirs = new int[]{1, 0, -1, 0, 1};
            int step = 0;
            boolean[][] isVisted = new boolean[m][n];
            isVisted[entrance[0]][entrance[1]] = true;
            while (!d.isEmpty()) {
                for (int i = d.size(); i > 0; i--) {
                    int[] pos = d.poll();
                    for (int j = 0; j < 4; j++) {
                        int x = pos[0] + dirs[j], y = pos[1] + dirs[j + 1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            continue;
                        }
                        if (maze[x][y] == '+' || isVisted[x][y]) {
                            continue;
                        }
                        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                            return step + 1;
                        }
                        d.offer(new int[]{x, y});
                        isVisted[x][y] = true;
                    }
                }
                step++;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       