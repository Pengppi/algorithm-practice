/**
 * @Title: 127.单词接龙
 * @TitleSlug: wordLadder
 * @Author: Neo
 * @Date: 2024-01-27 12:54:42
 */
package leetcode.editor.cn;

import java.util.*;

public class 单词接龙 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 单词接龙().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return 0;
            }
            Deque<String> queue = new ArrayDeque<>();
            queue.offer(beginWord);
            Set<String> set = new HashSet<>();
            int step = 1;
            while (!queue.isEmpty()) {
                step++;
                for (int i = queue.size(); i > 0; i--) {
                    String a = queue.poll();
                    for (int j = wordList.size() - 1; j >= 0; j--) {
                        String b = wordList.get(j);
                        if (set.contains(b)) {
                            wordList.remove(b);
                            continue;
                        }
                        if (isValid(a, b)) {
                            if (b.equals(endWord)) {
                                return step;
                            }
                            set.add(b);
                            queue.offer(b);
                        }
                    }
                }
            }
            return 0;
        }
        
        private boolean isValid(final String a, final String b) {
            if (a.length() != b.length()) {
                return false;
            }
            boolean first = true;
            for (int i = 0; i < a.length(); i++) {
                char c1 = a.charAt(i);
                char c2 = b.charAt(i);
                if (c1 != c2) {
                    if (first) {
                        first = false;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       