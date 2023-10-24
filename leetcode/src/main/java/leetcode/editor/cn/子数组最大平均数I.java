/**
 * @Title: 643.子数组最大平均数 I
 * @TitleSlug: maximumAverageSubarrayI
 * @Author: Neo
 * @Date: 2023-10-25 00:25:52
 */
package leetcode.editor.cn;

public class 子数组最大平均数I {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 子数组最大平均数I().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            double ans = sum;
            int n = nums.length;
            for (int i = k; i < n; i++) {
                sum += nums[i] - nums[i - k];
                ans = Math.max(ans, sum);
            }
            return ans / k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       