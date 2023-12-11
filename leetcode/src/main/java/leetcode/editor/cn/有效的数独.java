/**
 * @Title: 36.有效的数独
 * @TitleSlug: validSudoku
 * @Author: Neo
 * @Date: 2023-12-11 15:21:28
 */
package leetcode.editor.cn;

public class 有效的数独 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 有效的数独().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int len = 9;
            int[] row = new int[len];
            int[] col = new int[len];
            int[] block = new int[len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (Character.isDigit(board[i][j])) {
                        int id = i / 3 * 3 + j / 3;
                        int x = 1 << (board[i][j] - '0');
                        if ((row[i] & x) != 0 || (col[j] & x) != 0 || (block[id] & x) != 0) {
                            return false;
                        }
                        row[i] |= x;
                        col[j] |= x;
                        block[id] |= x;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       