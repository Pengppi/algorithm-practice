/**
 * @Title: 1800.最大升序子数组和
 * @TitleSlug: MaximumAscendingSubarraySum
 * @Author: Neo
 * @Date: 2022-10-07 23:31:09
 */
package leetcode.editor.cn;

public class 最大升序子数组和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最大升序子数组和().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAscendingSum(int[] nums) {
            int ans = 0;
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    sum += nums[i];
                } else {
                    ans = Math.max(ans, sum);
                    sum = nums[i];
                }
            }
            return Math.max(ans, sum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
