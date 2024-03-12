/**
 * @Title: 190.颠倒二进制位
 * @TitleSlug: reverseBits
 * @Author: Neo
 * @Date: 2024-03-12 09:25:25
 */
package leetcode.editor.cn;

public class 颠倒二进制位reverseBits {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 颠倒二进制位reverseBits().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int ans = 0;
            for (int i = 0; i < 32 && n != 0; i++) {
                ans |= (n & 1) << (31 - i);
                n >>>= 1;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       