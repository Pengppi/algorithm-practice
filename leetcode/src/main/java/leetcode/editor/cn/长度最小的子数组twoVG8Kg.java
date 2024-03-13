/**
 * @Title: LCR 008.长度最小的子数组
 * @TitleSlug: twoVG8Kg
 * @Author: Neo
 * @Date: 2024-03-13 09:38:59
 */
package leetcode.editor.cn;

public class 长度最小的子数组twoVG8Kg {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 长度最小的子数组twoVG8Kg().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length, sum = 0;
            int left = 0, right = 0, ans = Integer.MAX_VALUE;
            while (right < n) {
                sum += nums[right];
                while (sum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    sum -= nums[left++];
                }
                right++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       