/**
 * @Title: 1883.准时抵达会议现场的最小跳过休息次数
 * @TitleSlug: minimumSkipsToArriveAtMeetingOnTime
 * @Author: Neo
 * @Date: 2024-04-19 16:57:52
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 准时抵达会议现场的最小跳过休息次数minimumSkipsToArriveAtMeetingOnTime {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 准时抵达会议现场的最小跳过休息次数minimumSkipsToArriveAtMeetingOnTime().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] memo;
        private int[] dist;
        private int speed;
        
        public int minSkips(int[] dist, int speed, int hoursBefore) {
            long required = (long) speed * hoursBefore;
            if (Arrays.stream(dist).sum() > required) {
                return -1;
            }
            this.dist = dist;
            this.speed = speed;
            int n = dist.length;
            memo = new int[n][n - 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -1);
            }
            for (int i = 0; i < n; i++) {
                if (dfs(i, n - 2) + dist[n - 1] <= required) {
                    return i;
                }
            }
            return -1;
        }
        
        
        private int dfs(int i, int j) {
            if (j < 0) {
                return 0;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int res = (dfs(i, j - 1) + dist[j] + speed - 1) / speed * speed;
            if (i > 0) {
                res = Math.min(res, dfs(i - 1, j - 1) + dist[j]);
            }
            return memo[i][j] = res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       