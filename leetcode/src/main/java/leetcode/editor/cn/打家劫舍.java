/**
 * @Title: 198.打家劫舍 
 * @TitleSlug: HouseRobber
 * @Author: Neo
 * @Date: 2022-11-01 14:49:27
 */
package leetcode.editor.cn;
public class 打家劫舍{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 打家劫舍().new Solution();
    }
      
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int dp[] = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
