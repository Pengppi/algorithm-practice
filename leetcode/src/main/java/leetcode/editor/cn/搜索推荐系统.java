/**
 * @Title: 1268.搜索推荐系统
 * @TitleSlug: searchSuggestionsSystem
 * @Author: Neo
 * @Date: 2023-11-19 11:16:05
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 搜索推荐系统 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 搜索推荐系统().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Trie {
            private Trie[] children = new Trie[26];
            boolean isEnd = false;

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

            public List<String> search(String word) {
                Trie node = this;
                for (char c : word.toCharArray()) {
                    node = node.children[c - 'a'];
                    if (node == null) {
                        break;
                    }
                }
                List<String> res = new ArrayList<>();
                dfs(node, res, new StringBuilder(word));
                return res;
            }

            private void dfs(Trie node, List<String> res, StringBuilder sb) {
                if (node == null) {
                    return;
                }
                if (node.isEnd) {
                    res.add(sb.toString());
                }
                for (int i = 0; i < 26 && res.size() < 3; i++) {
                    if (node.children[i] != null) {
                        char c = (char) ('a' + i);
                        dfs(node.children[i], res, sb.append(c));
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }


        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            List<List<String>> ans = new ArrayList<>();
            Trie trie = new Trie();
            for (String prod : products) {
                trie.insert(prod);
            }
            StringBuilder sb = new StringBuilder();
            for (char c : searchWord.toCharArray()) {
                sb.append(c);
                ans.add(trie.search(sb.toString()));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       