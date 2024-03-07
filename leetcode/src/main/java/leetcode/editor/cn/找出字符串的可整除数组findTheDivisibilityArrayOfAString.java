/**
 * @Title: 2575.找出字符串的可整除数组
 * @TitleSlug: findTheDivisibilityArrayOfAString
 * @Author: Neo
 * @Date: 2024-03-07 00:51:14
 */
package leetcode.editor.cn;

public class 找出字符串的可整除数组findTheDivisibilityArrayOfAString {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 找出字符串的可整除数组findTheDivisibilityArrayOfAString().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] divisibilityArray(String word, int m) {
            int n = word.length();
            int[] ans = new int[n];
            long cur = 0;
            for (int i = 0; i < n; i++) {
                int num = word.charAt(i) - '0';
                cur = (cur * 10 + num) % m;
                if (cur == 0) {
                    ans[i] = 1;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       