/**
 * @Title: 1016.子串能表示从 1 到 N 数字的二进制串
 * @TitleSlug: binaryStringWithSubstringsRepresenting1ToN
 * @Author: Neo
 * @Date: 2023-05-11 00:26:32
 */
package leetcode.editor.cn;

public class 子串能表示从1到N数字的二进制串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 子串能表示从1到N数字的二进制串().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean queryString(String s, int n) {
            for (int i = 1; i <= n; i++) {
                String num = Integer.toBinaryString(i);
                if (!s.contains(num)) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       