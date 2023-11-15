/**
 * @Title: 2760.最长奇偶子数组
 * @TitleSlug: longestEvenOddSubarrayWithThreshold
 * @Author: Neo
 * @Date: 2023-11-16 00:12:40
 */
package leetcode.editor.cn;

public class 最长奇偶子数组 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 最长奇偶子数组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            int n = nums.length;
            int ans = 0, l = 0;
            while (l < n) {
                while (l < n && (nums[l] % 2 != 0 || nums[l] > threshold)) {
                    l++;
                }
                if (l >= n) {
                    break;
                }
                int r = l + 1;
                while (r < n && nums[r] % 2 != nums[r - 1] % 2 && nums[r] <= threshold) {
                    r++;
                }
                ans = Math.max(ans, r - l);
                l = r;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       