/**
 * @Title: 1235.规划兼职工作
 * @TitleSlug: MaximumProfitInJobScheduling
 * @Author: Neo
 * @Date: 2022-10-22 00:22:10
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 规划兼职工作 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 规划兼职工作().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n = startTime.length;
            int[][] jobs = new int[n][3];
            for (int i = 0; i < n; i++) {
                jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
            }
            Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));
            int[] dp = new int[n + 1];
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
                dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
            }
            return dp[n];
        }

        private int binarySearch(int[][] jobs, int r, int t) {
            int l = 0;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (jobs[m][1] > t) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
