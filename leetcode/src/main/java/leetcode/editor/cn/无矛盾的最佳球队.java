/**
 * @Title: 1626.无矛盾的最佳球队
 * @TitleSlug: bestTeamWithNoConflicts
 * @Author: Neo
 * @Date: 2023-03-22 15:57:13
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 无矛盾的最佳球队 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 无矛盾的最佳球队().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            int n = scores.length;
            int[][] p = new int[n][2];
            for (int i = 0; i < n; i++) {
                p[i][0] = scores[i];
                p[i][1] = ages[i];
            }
            Arrays.sort(p, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
            int[] dp = new int[n];
            dp[0] = p[0][0];
            int ans = dp[0];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (p[j][1] <= p[i][1]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] += p[i][0];
                ans = Math.max(ans, dp[i]);
            }
            return ans;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
