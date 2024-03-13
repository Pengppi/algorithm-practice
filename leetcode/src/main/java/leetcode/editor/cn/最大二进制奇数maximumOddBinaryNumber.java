/**
 * @Title: 2864.最大二进制奇数
 * @TitleSlug: maximumOddBinaryNumber
 * @Author: Neo
 * @Date: 2024-03-13 00:28:11
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 最大二进制奇数maximumOddBinaryNumber {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 最大二进制奇数maximumOddBinaryNumber().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumOddBinaryNumber(String s) {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(s.split("")).filter(e -> e.equals("1")).forEach(sb::append);
            while (sb.length() < s.length()) {
                sb.insert(sb.length() - 1, "0");
            }
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       