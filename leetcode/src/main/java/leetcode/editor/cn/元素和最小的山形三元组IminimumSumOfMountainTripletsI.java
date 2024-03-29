/**
 * @Title: 2908.元素和最小的山形三元组 I
 * @TitleSlug: minimumSumOfMountainTripletsI
 * @Author: Neo
 * @Date: 2024-03-29 00:26:36
 */
package leetcode.editor.cn;

public class 元素和最小的山形三元组IminimumSumOfMountainTripletsI {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 元素和最小的山形三元组IminimumSumOfMountainTripletsI().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSum(int[] nums) {
            int n = nums.length;
            int[] right = new int[n];
            right[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                right[i] = Math.min(right[i + 1], nums[i]);
            }
            int left = nums[0], ans = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                if (nums[i] > left && nums[i] > right[i]) {
                    ans = Math.min(ans, left + nums[i] + right[i]);
                }
                left = Math.min(left, nums[i]);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
            
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       