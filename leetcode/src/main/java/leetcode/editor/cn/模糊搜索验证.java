/**
 * @Title: LCR 137.模糊搜索验证
 * @TitleSlug: zhengZeBiaoDaShiPiPeiLcof
 * @Author: Neo
 * @Date: 2023-11-21 10:04:49
 */
package leetcode.editor.cn;

public class 模糊搜索验证 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 模糊搜索验证().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean articleMatch(String s, String p) {
            int n = s.length(), m = p.length();
            boolean[][] f = new boolean[n + 1][m + 1];
            f[0][0] = true;
            for (int i = 0; i <= n; i++) {
                char c1 = i > 0 ? s.charAt(i - 1) : ' ';
                for (int j = 1; j <= m; j++) {
                    char c2 = p.charAt(j - 1);
                    if (c2 != '*') {
                        if (c2 == '.' || c1 == c2) {
                            if (i > 0)
                                f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        f[i][j] |= f[i][j - 2];//匹配零个
                        char c3 = p.charAt(j - 2);
                        if (i > 0 && (c1 == c3 || c3 == '.')) {
                            f[i][j] |= f[i - 1][j];//匹配上一个
                        }
                    }
                }
            }

            return f[n][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       