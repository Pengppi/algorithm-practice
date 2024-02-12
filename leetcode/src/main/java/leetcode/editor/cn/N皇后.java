/**
 * @Title: 51.N 皇后
 * @TitleSlug: nQueens
 * @Author: Neo
 * @Date: 2024-02-12 12:59:09
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class N皇后 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new N皇后().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<String>> ans;
        private int n;
        
        public List<List<String>> solveNQueens(int n) {
            ans = new ArrayList<>();
            this.n = n;
            int[] board = new int[n];
            dfs(board, 0);
            return ans;
        }
        
        private void dfs(final int[] board, final int i) {
            if (i == n) {
                makeString(board);
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
                if (board[i] == board[j] || board[i] - board[j] == i - j || board[j] - board[i] == i-j) {
                    return false;
                }
            }
            return true;
        }
        
        private void makeString(final int[] board) {
            List<String> list = new ArrayList<>();
            for (final int i : board) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            ans.add(list);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       