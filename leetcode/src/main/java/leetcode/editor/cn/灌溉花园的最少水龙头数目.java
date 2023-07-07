/**
 * @Title: 1326.灌溉花园的最少水龙头数目
 * @TitleSlug: MinimumNumberOfTapsToOpenToWaterAGarden
 * @Author: Neo
 * @Date: 2023-02-21 23:35:32
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 灌溉花园的最少水龙头数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 灌溉花园的最少水龙头数目().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minTaps(int n, int[] ranges) {
            int[][] intervals = new int[n + 1][2];
            for (int i = 0; i <= n; i++) {
                int start = Math.max(i - ranges[i], 0);
                int end = Math.min(i + ranges[i], n);
                intervals[i] = new int[]{start, end};
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                if (dp[start] == Integer.MAX_VALUE) {
                    return -1;
                }
                for (int i = start; i <= end; i++) {
                    dp[i] = Math.min(dp[i], dp[start] + 1);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
