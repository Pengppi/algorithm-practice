/**
 * @Title: 198.打家劫舍
 * @TitleSlug: houseRobber
 * @Author: Neo
 * @Date: 2024-04-11 10:29:49
 */
package leetcode.editor.cn;

public class 打家劫舍houseRobber {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 打家劫舍houseRobber().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int[][] f = new int[n][2];
            f[0][1] = nums[0];
            int ans = nums[0];
            for (int i = 1; i < n; i++) {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
                f[i][1] = f[i - 1][0] + nums[i];
                ans = Math.max(ans, Math.max(f[i][0], f[i][1]));
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       