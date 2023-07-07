/**
 * @Title: 剑指 Offer 12.矩阵中的路径
 * @TitleSlug: juZhenZhongDeLuJingLcof
 * @Author: Neo
 * @Date: 2023-07-07 12:55:13
 */
package leetcode.editor.cn;

public class 矩阵中的路径 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 矩阵中的路径().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n;
        char[] cs;
        boolean[][] used;
        int[] dirs = new int[]{1, 0, -1, 0, 1};

        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            cs = word.toCharArray();
            used = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == cs[0]) {
                        if (dfs(board, i, j, 0)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int x, int y, int k) {
            if (board[x][y] != cs[k]) {
                return false;
            }
            if (k == cs.length - 1) {
                return true;
            }
            used[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i];
                int ny = y + dirs[i+1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (!used[nx][ny]) {
                    if (dfs(board, nx, ny, k + 1)) {
                        return true;
                    }
                }
            }
            used[x][y] = false;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       