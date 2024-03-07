/**
 * @Title: LCR 020.回文子串
 * @TitleSlug: a7VOhD
 * @Author: Neo
 * @Date: 2024-03-06 17:15:47
 */
package leetcode.editor.cn;

public class 回文子串a7VOhD {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 回文子串a7VOhD().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            char[] arr = s.toCharArray();
            int n = arr.length, ans = arr.length;
            boolean[][] f = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                f[i][i] = true;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j + i < n; j++) {
                    if (arr[j] != arr[j + i]) {
                        continue;
                    }
                    if (i == 1) {
                        f[j][j + i] = true;
                    } else {
                        f[j][j + i] = f[j + 1][j + i - 1];
                    }
                    if (f[j][j + i]) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       