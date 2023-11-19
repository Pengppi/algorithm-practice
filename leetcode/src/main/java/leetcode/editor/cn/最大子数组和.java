/**
 * @Title: 53.最大子数组和
 * @TitleSlug: maximumSubarray
 * @Author: Neo
 * @Date: 2023-11-20 00:13:32
 */
package leetcode.editor.cn;

public class 最大子数组和 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最大子数组和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length, ans = nums[0];
            int[] f = new int[n];
            f[0] = nums[0];
            for (int i = 1; i < n; i++) {
                f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
                ans = Math.max(ans, f[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       