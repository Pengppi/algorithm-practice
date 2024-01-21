/**
 * @Title: 410.分割数组的最大值
 * @TitleSlug: splitArrayLargestSum
 * @Author: Neo
 * @Date: 2024-01-21 23:05:40
 */
package leetcode.editor.cn;

public class 分割数组的最大值 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 分割数组的最大值().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int k) {
            int sum = 0, mx = 0;
            for (final int num : nums) {
                sum += num;
                mx = Math.max(mx, num);
            }
            int l = Math.max(mx - 1, (sum - 1) / k);
            int r = sum;
            while (l + 1 < r) {
                int m = l + (r - l) / 2;
                if (valid(nums, m, k)) {
                    r = m;
                } else {
                    l = m;
                }
            }
            return r;
        }
        
        private boolean valid(final int[] nums, final int targetSum, final int k) {
            int cnt = 1;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] > targetSum) {
                    if (cnt == k) {
                        return false;
                    }
                    cnt++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       