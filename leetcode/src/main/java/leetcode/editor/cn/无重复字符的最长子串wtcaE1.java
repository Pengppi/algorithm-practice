/**
 * @Title: LCR 016.无重复字符的最长子串
 * @TitleSlug: wtcaE1
 * @Author: Neo
 * @Date: 2024-03-25 10:44:09
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串wtcaE1 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 无重复字符的最长子串wtcaE1().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> charCnt = new HashMap<>();
            int l = 0, r = 0, ans = 0;
            while (r < s.length()) {
                char c = s.charAt(r++);
                charCnt.put(c, charCnt.getOrDefault(c, 0) + 1);
                while (charCnt.get(c) > 1) {
                    char d = s.charAt(l++);
                    charCnt.put(d, charCnt.get(d) - 1);
                }
                ans = Math.max(ans, r - l);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       