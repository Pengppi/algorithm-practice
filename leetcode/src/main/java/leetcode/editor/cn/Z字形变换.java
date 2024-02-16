/**
 * @Title: 6.Z 字形变换
 * @TitleSlug: ZigzagConversion
 * @Author: Neo
 * @Date: 2022-10-25 10:37:46
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class Z字形变换 {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new Z字形变换().new Solution();
    }
    
    // 力扣代码
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder[] strs = new StringBuilder[numRows];
            Arrays.setAll(strs, i -> new StringBuilder());
            StringBuilder ans = new StringBuilder();
            boolean down = true;
            int i = 0;
            for (final char c : s.toCharArray()) {
                strs[i].append(c);
                if (down) {
                    if (++i == numRows) {
                        down = false;
                        i = numRows - 2;
                    }
                } else {
                    if (--i == -1) {
                        down = true;
                        i = 1;
                    }
                }
            }
            for (final StringBuilder str : strs) {
                ans.append(str);
            }
            return ans.toString();
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}
