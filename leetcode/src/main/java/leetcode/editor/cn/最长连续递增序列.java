/**
 * @Title: 674.最长连续递增序列
 * @TitleSlug: longestContinuousIncreasingSubsequence
 * @Author: Neo
 * @Date: 2023-07-07 11:57:27
 */
package leetcode.editor.cn;

public class 最长连续递增序列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最长连续递增序列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int l = 0, r = 0;
            int ans = 0;
            for ( r = 1; r < nums.length; r++) {
                if (nums[r] <= nums[r - 1]) {
                    ans = Math.max(ans, r - l);
                    l = r;
                }
            }
            return Math.max(ans, r - l);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       