/**
 * @Title: 面试题 05.02.二进制数转字符串
 * @TitleSlug: BianryNumberToStringLcci
 * @Author: Neo
 * @Date: 2023-03-02 18:54:32
 */
package leetcode.editor.cn;

public class 二进制数转字符串 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二进制数转字符串().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String printBin(double num) {
            StringBuilder sb = new StringBuilder();
            sb.append("0.");
            while (num > 0) {
                num *= 2;
                if (num >= 1) {
                    sb.append(1);
                    num -= 1;
                } else {
                    sb.append(0);
                }
                if (sb.length() > 32) {
                    return "ERROR";
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
