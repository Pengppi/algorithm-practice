/**
 * @Title: 1031.两个非重叠子数组的最大和
 * @TitleSlug: maximumSumOfTwoNonOverlappingSubarrays
 * @Author: Neo
 * @Date: 2023-04-26 15:32:24
 */
package leetcode.editor.cn;

public class 两个非重叠子数组的最大和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 两个非重叠子数组的最大和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            return Math.max(f(firstLen, secondLen, preSum), f(secondLen, firstLen, preSum));
        }

        public int f(int firstLen, int secondLen, int[] sum) {
            int maxFirst = 0;
            int n = sum.length - 1;
            int res = 0;
            for (int i = firstLen; i <= n - secondLen; i++) {
                maxFirst = Math.max(maxFirst, sum[i] - sum[i - firstLen]);
                res = Math.max(maxFirst + sum[i + secondLen] - sum[i], res);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       