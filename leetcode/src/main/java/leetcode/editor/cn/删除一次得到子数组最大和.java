/**
 * @Title: 1186.删除一次得到子数组最大和
 * @TitleSlug: maximumSubarraySumWithOneDeletion
 * @Author: Neo
 * @Date: 2023-06-28 00:20:19
 */
package leetcode.editor.cn;

public class 删除一次得到子数组最大和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 删除一次得到子数组最大和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSum(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][2];
            int ans = arr[0];
            dp[0][0] = arr[0];
            dp[0][1] = 0;
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], 0) + arr[i];
                dp[i][1] = Math.max(arr[i] + dp[i - 1][1], dp[i - 1][0]);
                ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       