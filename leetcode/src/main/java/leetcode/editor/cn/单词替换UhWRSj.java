/**
 * @Title: LCR 063.单词替换
 * @TitleSlug: UhWRSj
 * @Author: Neo
 * @Date: 2024-02-27 22:44:17
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 单词替换UhWRSj {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 单词替换UhWRSj().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Trie root = new Trie();
        
        
        public String replaceWords(List<String> dictionary, String sentence) {
            dictionary.forEach(this::insert);
            return Arrays.stream(sentence.split(" "))
                    .map(this::search).collect(Collectors.joining(" "));
        }
        
        private void insert(String word) {
            Trie cur = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.next[idx] == null) {
                    cur.next[idx] = new Trie();
                }
                cur = cur.next[idx];
            }
            cur.s = word;
        }
        
        private String search(String word) {
            Trie cur = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.next[idx] == null) {
                    return word;
                }
                cur = cur.next[idx];
                if (cur.s != null) {
                    return cur.s;
                }
            }
            return word;
        }
        
        class Trie {
            Trie[] next = new Trie[26];
            String s;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       