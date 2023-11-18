/**
 * @Title: 72.编辑距离
 * @TitleSlug: editDistance
 * @Author: Neo
 * @Date: 2023-11-18 00:54:54
 */
package leetcode.editor.cn;

public class 编辑距离 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 编辑距离().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int n1 = word1.length(), n2 = word2.length();
            int[][] f = new int[n1 + 1][n2 + 1];
            for (int i = 0; i <= n1; i++) {
                f[i][0] = i;
            }
            for (int i = 0; i <= n2; i++) {
                f[0][i] = i;
            }
            for (int i = 1; i <= n1; i++) {
                char c1 = word1.charAt(i - 1);
                for (int j = 1; j <= n2; j++) {
                    char c2 = word2.charAt(j - 1);
                    if (c1 == c2) {
                        f[i][j] = f[i - 1][j - 1];
                    } else {
                        f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                    }
                }
            }
            return f[n1][n2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       