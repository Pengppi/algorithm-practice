/**
 * @Title: 12.整数转罗马数字
 * @TitleSlug: integerToRoman
 * @Author: Neo
 * @Date: 2024-04-09 11:43:26
 */
package leetcode.editor.cn;

public class 整数转罗马数字integerToRoman {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 整数转罗马数字integerToRoman().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String intToRoman(int num) {
            int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.length && num > 0; i++) {
                while (num >= values[i]) {
                    sb.append(roman[i]);
                    num -= values[i];
                }
            }
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       