/**
 * @Title: 130.被围绕的区域
 * @TitleSlug: surroundedRegions
 * @Author: Neo
 * @Date: 2024-02-18 16:40:58
 */
package leetcode.editor.cn;

public class 被围绕的区域 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 被围绕的区域().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] notSurrounded;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        
        public void solve(char[][] board) {
            int m = board.length, n = board[0].length;
            notSurrounded = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    dfs(board, i, 0);
                }
                if (board[i][n - 1] == 'O') {
                    dfs(board, i, n - 1);
                }
            }
            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O') {
                    dfs(board, 0, j);
                }
                if (board[m - 1][j] == 'O') {
                    dfs(board, m - 1, j);
                }
            }
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (board[i][j] == 'O' && !notSurrounded[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
            
        }
        
        private void dfs(final char[][] board, final int i, final int j) {
            notSurrounded[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                        && board[x][y] == 'O' && !notSurrounded[x][y]) {
                    dfs(board, x, y);
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       