/**
 * @Title: 1671.得到山形数组的最少删除次数
 * @TitleSlug: minimumNumberOfRemovalsToMakeMountainArray
 * @Author: Neo
 * @Date: 2023-12-22 00:36:21
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 得到山形数组的最少删除次数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 得到山形数组的最少删除次数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumMountainRemovals(int[] nums) {
            int n = nums.length, ans = 0;
            int[] pre = getLongestIncreasingSubsequence(nums);
            int[] suf = getLongestIncreasingSubsequence(reverse(nums));
            suf = reverse(suf);
            for (int i = 0; i < n; i++) {
                if (pre[i] > 1 && suf[i] > 1) {
                    int len = pre[i] + suf[i] - 1;
                    ans = Math.max(ans, len);
                }
            }
            return n - ans;
        }

        private int[] reverse(int[] nums) {
            int n = nums.length;
            int[] re = new int[n];
            for (int i = 0; i < n; i++) {
                re[n - 1 - i] = nums[i];
            }
            return re;
        }

        private int[] getLongestIncreasingSubsequence(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       