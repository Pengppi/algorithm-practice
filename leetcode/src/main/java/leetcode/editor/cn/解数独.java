/**
 * @Title: 37.解数独
 * @TitleSlug: sudokuSolver
 * @Author: Neo
 * @Date: 2023-07-06 21:50:44
 */
package leetcode.editor.cn;

public class 解数独 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 解数独().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            int n = 9;
            int[] rowUsed = new int[n];
            int[] colUsed = new int[n];
            int[][] boxUsed = new int[3][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = board[i][j] - '0';
                    rowUsed[i] |= (1 << num);
                    colUsed[j] |= (1 << num);
                    boxUsed[i / 3][j / 3] |= (1 << num);
                }
            }
            dfs(board, boxUsed, rowUsed, colUsed, 0, 0);
        }

        private boolean dfs(char[][] board, int[][] boxUsed, int[] rowUsed, int[] colUsed, int row, int col) {
            if (col == board[0].length) {
                col = 0;
                row++;
                if (row == board.length) {
                    return true;
                }
            }
            if (board[row][col] == '.') {
                for (int i = 1; i <= 9; i++) {
                    boolean f1 = ((rowUsed[row] >> i) & 1) == 0;
                    boolean f2 = ((colUsed[col] >> i) & 1) == 0;
                    boolean f3 = ((boxUsed[row / 3][col / 3] >> i) & 1) == 0;
                    if (f1 && f2 && f3) {
                        rowUsed[row] |= (1 << i);
                        colUsed[col] |= (1 << i);
                        boxUsed[row / 3][col / 3]  |= (1 << i);
                        board[row][col] = (char) ('0' + i);
                        if (dfs(board, boxUsed, rowUsed, colUsed, row, col + 1)) {
                            return true;
                        }
                        board[row][col] = '.';
                        rowUsed[row] &= ~(1 << i);
                        colUsed[col] &= ~(1 << i);
                        boxUsed[row / 3][col / 3]  &= ~(1 << i);
                    }
                }
            } else {
                return dfs(board, boxUsed, rowUsed, colUsed, row, col + 1);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       