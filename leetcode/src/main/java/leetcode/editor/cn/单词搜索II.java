/**
 * @Title: 212.单词搜索 II
 * @TitleSlug: wordSearchIi
 * @Author: Neo
 * @Date: 2024-02-25 13:34:22
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 单词搜索II {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 单词搜索II().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] board;
        int m, n;
        boolean[][] visited;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        
        Trie root = new Trie();
        List<String> ans = new ArrayList<>();
        
        public List<String> findWords(char[][] board, String[] words) {
            this.board = board;
            m = board.length;
            n = board[0].length;
            visited = new boolean[m][n];
            Arrays.stream(words).distinct().forEach(this::insert);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(i, j, root);
                }
            }
            return ans;
        }
        
        private void insert(String word) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                int x = c - 'a';
                if (node.children[x] == null) {
                    node.children[x] = new Trie();
                }
                node = node.children[x];
            }
            node.word = word;
        }
        
        private void dfs(final int i, final int j, Trie node) {
            int x = board[i][j] - 'a';
            if (node.children[x] == null) {
                return;
            }
            node = node.children[x];
            if (node.word != null) {
                ans.add(node.word);
                node.word = null;
            }
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int ni = i + dirs[k];
                int nj = j + dirs[k + 1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    dfs(ni, nj, node);
                }
            }
            visited[i][j] = false;
        }
        
        class Trie {
            Trie[] children = new Trie[26];
            String word;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       