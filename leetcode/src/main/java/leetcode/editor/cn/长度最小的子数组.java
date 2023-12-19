/**
 * @Title: 209.长度最小的子数组
 * @TitleSlug: minimumSizeSubarraySum
 * @Author: Neo
 * @Date: 2023-12-19 00:39:06
 */
package leetcode.editor.cn;

public class 长度最小的子数组 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 长度最小的子数组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0, len = 0, n = nums.length, ans = n + 1;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                len++;
                while (sum >= target) {
                    ans = Math.min(ans, len);
                    sum -= nums[i - len + 1];
                    len--;
                }
            }
            return ans == n + 1 ? 0 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       