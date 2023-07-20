/**
 * @Title: 918.环形子数组的最大和
 * @TitleSlug: maximumSumCircularSubarray
 * @Author: Neo
 * @Date: 2023-07-20 11:42:46
 */
package leetcode.editor.cn;

public class 环形子数组的最大和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 环形子数组的最大和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int totSum = 0, curMax = 0, curMin = 0, maxSum = Integer.MIN_VALUE, minSum = 0;
            for (int x : nums) {
                totSum += x;

                curMax = Math.max(curMax, 0) + x;
                maxSum = Math.max(maxSum, curMax);

                curMin = Math.min(curMin, 0) + x;
                minSum = Math.min(curMin, minSum);
            }

            return totSum == minSum ? maxSum : Math.max(maxSum, totSum - minSum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       