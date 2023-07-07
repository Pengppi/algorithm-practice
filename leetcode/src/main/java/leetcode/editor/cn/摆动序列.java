/**
 * @Title: 376.摆动序列
 * @TitleSlug: WiggleSubsequence
 * @Author: Neo
 * @Date: 2022-11-01 14:22:30
 */
package leetcode.editor.cn;

public class 摆动序列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 摆动序列().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            int down = 1, up = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    up = down + 1;
                }
                if (nums[i] < nums[i - 1]) {
                    down = up + 1;
                }
            }
            return Math.max(down,up);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
