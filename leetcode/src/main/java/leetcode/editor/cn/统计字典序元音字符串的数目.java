/**
 * @Title: 1641.统计字典序元音字符串的数目
 * @TitleSlug: countSortedVowelStrings
 * @Author: Neo
 * @Date: 2023-03-29 14:37:08
 */
package leetcode.editor.cn;

public class 统计字典序元音字符串的数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 统计字典序元音字符串的数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countVowelStrings(int n) {
            int[][] f = new int[n + 1][5];
            for (int i = 0; i < 5; i++) {
                f[1][i] = 1;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = j; k < 5; k++) {
                        f[i][j] += f[i - 1][k];
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < 5; i++) {
                ans += f[n][i];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
