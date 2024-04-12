/**
 * @Title: LCR 065.单词的压缩编码
 * @TitleSlug: iSwD2y
 * @Author: Neo
 * @Date: 2024-04-12 00:32:22
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 单词的压缩编码iSwD2y {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 单词的压缩编码iSwD2y().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final Trie root = new Trie();
        
        public int minimumLengthEncoding(String[] words) {
            return Arrays.stream(words).distinct()
                    .sorted((a, b) -> (b.length() - a.length()))
                    .filter(w -> root.insert(w) == 1)
                    .mapToInt(w -> w.length() + 1).sum();
        }
        
        private class Trie {
            Trie[] children;
            int cnt;
            
            public Trie() {
                children = new Trie[26];
                cnt = 0;
            }
            
            
            public int insert(String word) {
                Trie cur = this;
                for (int i = word.length() - 1; i >= 0; i--) {
                    char c = word.charAt(i);
                    int j = c - 'a';
                    if (cur.children[j] == null) {
                        cur.children[j] = new Trie();
                        
                    }
                    cur = cur.children[j];
                    cur.cnt++;
                }
                return cur.cnt == 1 ? 1 : 0;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       