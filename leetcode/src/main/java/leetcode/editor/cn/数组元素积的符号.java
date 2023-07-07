/**
 * @Title: 1822.数组元素积的符号
 * @TitleSlug: SignOfTheProductOfAnArray
 * @Author: Neo
 * @Date: 2022-10-27 14:07:01
 */
package leetcode.editor.cn;

public class 数组元素积的符号 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 数组元素积的符号().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arraySign(int[] nums) {
            int ans = 1;
            for (int num : nums) {
                if (num < 0) {
                    ans = -ans;
                }
                if (num == 0) {
                    return 0;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
