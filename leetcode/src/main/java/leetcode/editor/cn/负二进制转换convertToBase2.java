/**
 * @Title: 1017.负二进制转换
 * @TitleSlug: convertToBase2
 * @Author: Neo
 * @Date: 2024-04-28 00:03:54
 */
package leetcode.editor.cn;

public class 负二进制转换convertToBase2 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 负二进制转换convertToBase2().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String baseNeg2(int n) {
            if (n == 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                sb.append(n & 1);
                n = -(n >> 1);
            }
            return sb.reverse().toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       