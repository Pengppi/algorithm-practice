/**
 * @Title: 289.生命游戏
 * @TitleSlug: gameOfLife
 * @Author: Neo
 * @Date: 2024-04-28 22:57:30
 */
package leetcode.editor.cn;

public class 生命游戏gameOfLife {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 生命游戏gameOfLife().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void gameOfLife(int[][] board) {
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        int liveNum = getLiveNum(board, i, j);
                        if (liveNum < 2 || liveNum > 3) {
                            board[i][j] = 2;
                        }
                    } else {
                        int liveNum = getLiveNum(board, i, j);
                        if (liveNum == 3) {
                            board[i][j] = -1;
                        }
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 2) {
                        board[i][j] = 0;
                    } else if (board[i][j] == -1) {
                        board[i][j] = 1;
                    }
                }
            }
        }
        
        private int getLiveNum(int[][] board, int x, int y) {
            int res = 0;
            for (int i = Math.max(0, x - 1); i <= Math.min(x + 1, board.length - 1); i++) {
                for (int j = Math.max(0, y - 1); j <= Math.min(y + 1, board[0].length - 1); j++) {
                    if (i == x && j == y) {
                        continue;
                    }
                    if (board[i][j] > 0) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}

