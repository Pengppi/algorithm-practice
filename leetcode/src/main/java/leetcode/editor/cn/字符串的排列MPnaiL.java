/**
 * @Title: LCR 014.字符串的排列
 * @TitleSlug: MPnaiL
 * @Author: Neo
 * @Date: 2024-02-26 23:49:54
 */
package leetcode.editor.cn;

public class 字符串的排列MPnaiL {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 字符串的排列MPnaiL().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            int[] cnt = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                cnt[s1.charAt(i) - 'a']++;
                cnt[s2.charAt(i) - 'a']--;
            }
            int i = s1.length();
            do {
                if (isAllZero(cnt)) {
                    return true;
                }
                if (i < s2.length()) {
                    cnt[s2.charAt(i - s1.length()) - 'a']++;
                    cnt[s2.charAt(i) - 'a']--;
                }
            } while (++i < s2.length());
            return isAllZero(cnt);
        }
        
        private boolean isAllZero(final int[] cnt) {
            for (final int i : cnt) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       