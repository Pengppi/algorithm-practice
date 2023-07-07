/**
 * @Title: 1147.段式回文
 * @TitleSlug: longestChunkedPalindromeDecomposition
 * @Author: Neo
 * @Date: 2023-04-12 00:34:47
 */
package leetcode.editor.cn;

public class 段式回文 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 段式回文().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestDecomposition(String text) {
            int n = text.length();
            if (n == 0) {
                return 0;
            }
            for (int i = 1; i <= n / 2; i++) {
                if (text.substring(0, i).equals(text.substring(n - i))) {
                    return 2 + longestDecomposition(text.substring(i, n - i));
                }
            }
            return 1;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)
}
