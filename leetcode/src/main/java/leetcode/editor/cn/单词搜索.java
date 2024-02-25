/**
 * @Title: 79.单词搜索
 * @TitleSlug: wordSearch
 * @Author: Neo
 * @Date: 2024-02-25 13:10:58
 */
package leetcode.editor.cn;

public class 单词搜索 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 单词搜索().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        char[][] board;
        char[] charArr;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        int m, n;
        
        public boolean exist(char[][] board, String word) {
            this.board = board;
            m = board.length;
            n = board[0].length;
            visited = new boolean[m][n];
            charArr = word.toCharArray();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        private boolean dfs(final int i, final int j, final int x) {
            if (board[i][j] != charArr[x]) {
                return false;
            }
            if (x == charArr.length - 1) {
                return true;
            }
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int ni = i + dirs[k];
                int nj = j + dirs[k + 1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    if (dfs(ni, nj, x + 1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       