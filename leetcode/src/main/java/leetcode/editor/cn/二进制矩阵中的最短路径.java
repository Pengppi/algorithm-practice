/**
 * @Title: 1091.二进制矩阵中的最短路径
 * @TitleSlug: shortestPathInBinaryMatrix
 * @Author: Neo
 * @Date: 2023-05-26 21:58:06
 */
package leetcode.editor.cn;

public class 二进制矩阵中的最短路径 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二进制矩阵中的最短路径().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if (n == 1 && grid[0][0] == 0) {
                return 1;
            }

            if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
                return -1;
            }
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;
            int path = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                path++;
                while (size-- > 0) {
                    int[] cell = queue.poll();
                    for (int[] direction : directions) {
                        int x = cell[0] + direction[0];
                        int y = cell[1] + direction[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0 && !visited[x][y]) {
                            if (x == n - 1 && y == n - 1) {
                                return path;
                            }
                            queue.offer(new int[]{x, y});
                            visited[x][y] = true;
                        }
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       