/**
 * @Title: 79.单词搜索
 * @TitleSlug: wordSearch
 * @Author: Neo
 * @Date: 2024-04-01 00:56:48
 */
package leetcode.editor.cn;

public class 单词搜索wordSearch {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 单词搜索wordSearch().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int m, n;
        private char[][] board;
        private boolean[][] visited;
        private int[] dirs = new int[]{-1, 0, 1, 0, -1};
        
        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            this.board = board;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(i, j, 0, word)) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        private boolean dfs(int i, int j, int x, String word) {
            if (board[i][j] != word.charAt(x)) {
                return false;
            }
            if (x == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int ni = i + dirs[k], nj = j + dirs[k + 1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    if (dfs(ni, nj, x + 1, word)) {
                        return true;
                    }
                }
            }
            return visited[i][j] = false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       