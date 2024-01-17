/**
 * @Title: 2744.最大字符串配对数目
 * @TitleSlug: findMaximumNumberOfStringPairs
 * @Author: Neo
 * @Date: 2024-01-17 08:57:11
 */
package leetcode.editor.cn;


public class 最大字符串配对数目 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最大字符串配对数目().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumNumberOfStringPairs(String[] words) {
            int ans = 0, n = words.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (check(words[i], words[j])) {
                        ans++;
                    }
                }
            }
            return ans;
        }
        
        private boolean check(final String w1, final String w2) {
            if (w1.length() != w2.length()) {
                return false;
            }
            int l = 0, r = w1.length() - 1;
            while (l < w1.length()) {
                if (w1.charAt(l++) != w2.charAt(r--)) {
                    return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       