/**
 * @Title: 1048.最长字符串链
 * @TitleSlug: longestStringChain
 * @Author: Neo
 * @Date: 2023-04-27 11:09:17
 */
package leetcode.editor.cn;

import javafx.concurrent.Worker;

import java.util.Arrays;
import java.util.Map;

public class 最长字符串链 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最长字符串链().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;
        Map<String, Integer> map;

        public int longestStrChain(String[] words) {
            map = new HashMap<>();
            Arrays.sort(words, (a, b) -> a.length() - b.length());
            for (int i = 0; i < words.length; i++) {
                dfs(words, i,1);
            }
            return ans;
        }

        public int dfs(String[] words, int index, int count) {
            ans = Math.max(ans, count);
            if (map.containsKey(words[index])) {
                return map.get(words[index]);
            }
            if (index == words.length) {
                return count;
            }
            int res = count;
            for (int i = index + 1; i < words.length; i++) {
                if (words[i].length() - words[index].length() > 1) {
                    break;
                }
                if (isPredecessor(words[index], words[i])) {
                    res = dfs(words, i, count + 1);
                }
            }
            map.put(words[index], res);
            return res;
        }

        public boolean isPredecessor(String a, String b) {
            if (a.length() + 1 != b.length()) {
                return false;
            }
            int i = 0, j = 0;
            while (i < a.length() && j < b.length()) {
                if (a.charAt(i) == b.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            return i == a.length();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       