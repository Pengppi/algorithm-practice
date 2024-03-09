/**
 * @Title: 211.添加与搜索单词 - 数据结构设计
 * @TitleSlug: designAddAndSearchWordsDataStructure
 * @Author: Neo
 * @Date: 2024-03-10 00:24:25
 */
package leetcode.editor.cn;

public class 添加与搜索单词数据结构设计designAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 添加与搜索单词数据结构设计designAddAndSearchWordsDataStructure().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        private Trie root;
        
        public WordDictionary() {
            root = new Trie();
        }
        
        public void addWord(String word) {
            Trie cur = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.next[idx] == null) {
                    cur.next[idx] = new Trie();
                }
                cur = cur.next[idx];
            }
            cur.isEnd = true;
        }
        
        public boolean search(String word) {
            Trie cur = root;
            return dfs(word.toCharArray(), 0, cur);
        }
        
        private boolean dfs(char[] arr, int x, Trie cur) {
            if (x == arr.length) {
                return cur.isEnd;
            }
            if (arr[x] == '.') {
                for (int i = 0; i < 26; i++) {
                    if (cur.next[i] != null && dfs(arr, x + 1, cur.next[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = arr[x] - 'a';
                if (cur.next[idx] == null) {
                    return false;
                }
                return dfs(arr, x + 1, cur.next[idx]);
            }
        }
        
        private class Trie {
            protected boolean isEnd;
            protected Trie[] next = new Trie[26];
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       