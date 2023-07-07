/**
 * @Title: 剑指 Offer 42.连续子数组的最大和
 * @TitleSlug: lianXuZiShuZuDeZuiDaHeLcof
 * @Author: Neo
 * @Date: 2023-07-07 17:17:27
 */
package leetcode.editor.cn;

public class 连续子数组的最大和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 连续子数组的最大和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[][] d = new int[n][2];
            d[0][0] = nums[0];
            d[0][1] = nums[0];
            for (int i = 1; i < n; i++) {
                d[i][1] = nums[i] + Math.max(0, d[i - 1][1]);
                d[i][0] = Math.max(d[i - 1][0], d[i - 1][1]);
            }
            return Math.max(d[n - 1][0], d[n - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       