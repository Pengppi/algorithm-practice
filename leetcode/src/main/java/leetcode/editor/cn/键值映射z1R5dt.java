/**
 * @Title: LCR 066. 键值映射
 * @TitleSlug: z1R5dt
 * @Author: Neo
 * @Date: 2024-04-26 13:42:49
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 键值映射z1R5dt {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 键值映射z1R5dt().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {
        private Trie root;
        private Map<String, Integer> map;
        
        public MapSum() {
            root = new Trie();
            map = new HashMap<>();
        }
        
        public void insert(String key, int val) {
            Trie cur = root;
            int diff = val - map.getOrDefault(key, 0);
            map.put(key, val);
            for (char c : key.toCharArray()) {
                int i = c - 'a';
                if (cur.next[i] == null) {
                    cur.next[i] = new Trie();
                }
                cur = cur.next[i];
                cur.val += diff;
            }
        }
        
        public int sum(String prefix) {
            Trie cur = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                cur = cur.next[i];
                if (cur == null) {
                    return 0;
                }
            }
            return cur.val;
        }
        
        private class Trie {
            Trie[] next;
            int val = 0;
            
            public Trie() {
                next = new Trie[26];
            }
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// leetcode submit region end(Prohibit modification and deletion)

}
       