/**
 * @Title: 1156.单字符重复子串的最大长度
 * @TitleSlug: swapForLongestRepeatedCharacterSubstring
 * @Author: Neo
 * @Date: 2023-06-03 23:18:12
 */
package leetcode.editor.cn;

public class 单字符重复子串的最大长度 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 单字符重复子串的最大长度().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepOpt1(String text) {
            int[] cnt = new int[26];
            char[] chars = text.toCharArray();
            for (char c : chars) {
                cnt[c - 'a']++;
            }
            int n = text.length();
            int ans = 0;
            for (int i = 0; i < n; ) {
                char c = chars[i];
                int j = i;
                while (j < n && chars[j] == c) {
                    j++;
                }
                int len = j - i;
                if (len < cnt[c - 'a'] && (j < n - 1 || i > 0)) {
                    ans = Math.max(ans, len + 1);
                }
                int k = j + 1;
                while (k < n && chars[k] == c) {
                    k++;
                }
                ans = Math.max(ans, Math.min(k - i, cnt[c - 'a']));
                i = j;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       