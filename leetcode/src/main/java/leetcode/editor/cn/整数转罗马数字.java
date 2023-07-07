/**
 * @Title: 12.整数转罗马数字
 * @TitleSlug: IntegerToRoman
 * @Author: Neo
 * @Date: 2022-10-26 11:50:37
 */
package leetcode.editor.cn;

public class 整数转罗马数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 整数转罗马数字().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String intToRoman(int num) {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    sb.append(rom[i]);
                    num -= values[i];
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
