/**
 * @Title: 2707.字符串中的额外字符
 * @TitleSlug: extraCharactersInAString
 * @Author: Neo
 * @Date: 2024-01-09 13:35:01
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 字符串中的额外字符 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 字符串中的额外字符().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minExtraChar(String s, String[] dictionary) {
            int n = s.length();
            int[] f = new int[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                f[i] = f[i + 1] + 1;
                String cur = s.substring(i);
                for (String word : dictionary) {
                    if (cur.startsWith(word)) {
                        f[i] = Math.min(f[i], f[i + word.length()]);
                    }
                }
            }
            return f[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       