/**
 * @Title: 30.串联所有单词的子串
 * @TitleSlug: substringWithConcatenationOfAllWords
 * @Author: Neo
 * @Date: 2024-03-28 17:28:04
 */
package leetcode.editor.cn;

import java.util.*;

public class 串联所有单词的子串substringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 串联所有单词的子串substringWithConcatenationOfAllWords().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ans = new ArrayList<>();
            int wordLen = words[0].length();
            int totalLen = words.length * words[0].length();
            Map<String, Integer> map = new HashMap<>();
            Arrays.stream(words).forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
            int i = 0;
            while (i + totalLen <= s.length()) {
                int j = i;
                var tmp = new HashMap<String, Integer>();
                int cnt = 0;
                while (j < i + totalLen) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < wordLen; k++) {
                        sb.append(s.charAt(j + k));
                    }
                    String str = sb.toString();
                    int num = map.getOrDefault(str, -1);
                    if (num == -1) {
                        break;
                    }
                    tmp.put(str, tmp.getOrDefault(str, 0) + 1);
                    if (tmp.get(str) > num) {
                        break;
                    }
                    cnt++;
                    j += wordLen;
                }
                if (cnt == words.length) {
                    ans.add(i);
                }
                i++;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       