/**
 * @Title: 289.生命游戏
 * @TitleSlug: gameOfLife
 * @Author: Neo
 * @Date: 2023-12-15 21:55:05
 */
package leetcode.editor.cn;

public class 生命游戏 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 生命游戏().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dir = new int[]{0, 1, -1};
        int m, n;

        public void gameOfLife(int[][] board) {
            m = board.length;
            n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int cntLive = countNeighbors(board, i, j);
                    if (board[i][j] == 0 && cntLive == 3) {
                        board[i][j] = 2;
                    }
                    if (board[i][j] == 1 && (cntLive < 2 || cntLive > 3)) {
                        board[i][j] = -1;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] > 0) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }

        }

        private int countNeighbors(int[][] board, int x, int y) {
            int res = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!(i == 0 && j == 0)) {
                        int nx = x + dir[i], ny = y + dir[j];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && Math.abs(board[nx][ny]) == 1) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       