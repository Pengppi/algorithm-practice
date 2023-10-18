/**
 * @Title: 1004.最大连续1的个数 III
 * @TitleSlug: maxConsecutiveOnesIii
 * @Author: Neo
 * @Date: 2023-10-18 11:20:56
 */
package leetcode.editor.cn;

public class 最大连续1的个数III {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最大连续1的个数III().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int n = nums.length, l = 0, cnt0 = 0, ans = 0;
            for (int r = 0; r < n; r++) {
                cnt0 += 1 - nums[r];
                while (cnt0 > k) {
                    cnt0 -= 1 - nums[l++];
                }
                ans = Math.max(ans, r - l + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       