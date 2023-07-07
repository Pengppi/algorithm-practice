/**
 * @Title: 6.Z 字形变换
 * @TitleSlug: ZigzagConversion
 * @Author: Neo
 * @Date: 2022-10-25 10:37:46
 */
package leetcode.editor.cn;

public class Z字形变换 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new Z字形变换().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            String[] strs = new String[numRows];
            for (int i = 0; i < numRows; i++) {
                strs[i] = "";
            }
            int i = 0;
            boolean up = true;
            for (char c : s.toCharArray()) {
                strs[i] += c;
                if (up) {
                    i++;
                    if (i == numRows) {
                        up = false;
                        i = numRows - 2;
                    }
                } else {
                    i--;
                    if (i == -1) {
                        up = true;
                        i = 1;
                    }
                }
            }
            String ans = "";
            for (String str : strs) {
                ans += str;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
