/**
 * @Title: 52.N 皇后 II
 * @TitleSlug: nQueensIi
 * @Author: Neo
 * @Date: 2024-02-12 12:58:33
 */
package leetcode.editor.cn;

public class N皇后II {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new N皇后II().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int n, ans;
        
        public int totalNQueens(int n) {
            this.n = n;
            int[] board = new int[n];
            dfs(board, 0);
            return ans;
        }
        
        private void dfs(final int[] board, final int i) {
            if (i == n) {
                ans++;
                return;
            }
            for (int j = 0; j < n; j++) {
                board[i] = j;
                if (isValid(board, i)) {
                    dfs(board, i + 1);
                }
            }
        }
        
        private boolean isValid(final int[] board, final int i) {
            for (int j = 0; j < i; j++) {
                if (board[i] == board[j] || board[i] - board[j] == i - j || board[j] - board[i] == i - j) {
                    return false;
                }
            }
            return true;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       