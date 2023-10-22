/**
 * @Title: 208.实现 Trie (前缀树)
 * @TitleSlug: implementTriePrefixTree
 * @Author: Neo
 * @Date: 2023-10-22 14:44:38
 */
package leetcode.editor.cn;

public class 实现Trie(前缀树) {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 实现Trie(前缀树) ().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private boolean isEnd;
        private Trie[] children;

        public Trie() {
            isEnd = false;
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int pos = c - 'a';
                if (node.children[pos] == null) {
                    node.children[pos] = new Trie();
                }
                node = node.children[pos];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                node = node.children[c - 'a'];
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            for (char c : prefix.toCharArray()) {
                node = node.children[c - 'a'];
                if (node == null) {
                    return false;
                }
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
        
       