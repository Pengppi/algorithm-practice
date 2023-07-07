/**
 * @Title: 3.无重复字符的最长子串
 * @TitleSlug: LongestSubstringWithoutRepeatingCharacters
 * @Author: Neo
 * @Date: 2022-10-22 12:20:50
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 无重复字符的最长子串().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Deque<Character> deque = new ArrayDeque<>();
            int ans = 0;
            for (char c : s.toCharArray()) {
                while (deque.contains(c)) {
                    deque.pollFirst();
                }
                deque.add(c);
                ans = Math.max(ans, deque.size());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
