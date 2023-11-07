/**
 * @Title: 1143.最长公共子序列
 * @TitleSlug: longestCommonSubsequence
 * @Author: Neo
 * @Date: 2023-11-08 00:28:30
 */
package leetcode.editor.cn;

public class 最长公共子序列 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最长公共子序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length(), n2 = text2.length();
            int[][] f = new int[n1 + 1][n2 + 1];
            for (int i = 1; i <= n1; i++) {
                char c1 = text1.charAt(i-1);
                for (int j = 1; j <= n2; j++) {
                    char c2 = text2.charAt(j-1);
                    if (c1 == c2) {
                        f[i][j] = 1 + f[i - 1][j - 1];
                    } else {
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    }
                }
            }

            return f[n1][n2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       