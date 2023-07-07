/**
 * @Title: 2399.检查相同字母间的距离
 * @TitleSlug: checkDistancesBetweenSameLetters
 * @Author: Neo
 * @Date: 2023-04-09 14:59:22
 */
package leetcode.editor.cn;

import java.util.HashSet;

public class 检查相同字母间的距离 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 检查相同字母间的距离().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkDistances(String s, int[] distance) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (set.add(c)) {
                    int pos = i + distance[c - 'a'] + 1;
                    if (pos >= n || s.charAt(pos) != c) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
