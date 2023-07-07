/**
 * @Title: 1092.最短公共超序列
 * @TitleSlug: shortestCommonSupersequence
 * @Author: Neo
 * @Date: 2023-03-28 08:45:48
 */
package leetcode.editor.cn;

public class 最短公共超序列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最短公共超序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            int n = str1.length();
            int m = str2.length();
            int[][] f = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                char c1 = str1.charAt(i - 1);
                for (int j = 1; j <= m; j++) {
                    char c2 = str2.charAt(j - 1);
                    if (c1 == c2) {
                        f[i][j] = f[i - 1][j - 1] + 1;
                    } else {
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    }
                }
            }
            StringBuilder ans = new StringBuilder();
            int i = n, j = m;
            while (i > 0 && j > 0) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    ans.append(c1);
                    i--;
                    j--;
                } else {
                    if (f[i - 1][j] > f[i][j - 1]) {
                        ans.append(c1);
                        i--;
                    } else {
                        ans.append(c2);
                        j--;
                    }
                }
            }
            while (i > 0) {
                ans.append(str1.charAt(i - 1));
                i--;
            }
            while (j > 0) {
                ans.append(str2.charAt(j - 1));
                j--;
            }
            return ans.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
