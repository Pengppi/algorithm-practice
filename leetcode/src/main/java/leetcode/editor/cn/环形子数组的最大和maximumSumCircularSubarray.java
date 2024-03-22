/**
 * @Title: 918.环形子数组的最大和
 * @TitleSlug: maximumSumCircularSubarray
 * @Author: Neo
 * @Date: 2024-03-22 20:54:35
 */
package leetcode.editor.cn;

public class 环形子数组的最大和maximumSumCircularSubarray {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 环形子数组的最大和maximumSumCircularSubarray().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            int sum = nums[0];
            int mn = nums[0], mx = nums[0];
            int[] f1 = new int[n];
            int[] f2 = new int[n];
            f1[0] = f2[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sum += nums[i];
                f1[i] = Math.max(f1[i - 1] + nums[i], nums[i]);
                f2[i] = Math.min(f2[i - 1] + nums[i], nums[i]);
                mx = Math.max(mx, f1[i]);
                mn = Math.min(mn, f2[i]);
            }
            return sum == mn ? mx : Math.max(mx, sum - mn);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       