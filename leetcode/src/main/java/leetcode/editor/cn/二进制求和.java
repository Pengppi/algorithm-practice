/**
 * @Title: 67.二进制求和
 * @TitleSlug: addBinary
 * @Author: Neo
 * @Date: 2024-02-05 14:35:49
 */
package leetcode.editor.cn;

public class 二进制求和 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二进制求和().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            var c1 = a.toCharArray();
            var c2 = b.toCharArray();
            int carry = 0, i = c1.length-1, j = c2.length-1;
            StringBuilder sb = new StringBuilder();
            while (i >= 0 || j >= 0 || carry > 0) {
                if (i >= 0) {
                    carry += (c1[i--] - '0');
                }
                if (j >= 0) {
                    carry += (c2[j--] - '0');
                }
                sb.append(carry % 2);
                carry = carry / 2;
            }
            return sb.reverse().toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       