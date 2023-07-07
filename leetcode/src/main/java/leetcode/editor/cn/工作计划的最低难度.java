/**
 * @Title: 1335.工作计划的最低难度
 * @TitleSlug: minimumDifficultyOfAJobSchedule
 * @Author: Neo
 * @Date: 2023-05-16 00:35:10
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 工作计划的最低难度 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 工作计划的最低难度().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDifficulty(int[] jobDifficulty, int d) {
            int n = jobDifficulty.length;
            if (n < d) {
                return -1;
            }
            int[][] f = new int[d][n];
            f[0][0] = jobDifficulty[0];
            for (int i = 1; i < n; i++) {
                f[0][i] = Math.max(f[0][i - 1], jobDifficulty[i]);
            }
            for (int i = 1; i < d; i++) {
                for (int j = i; j < n; j++) {
                    f[i][j] = Integer.MAX_VALUE;
                    int mx = 0;
                    for (int k = j; k >= i; k--) {
                        mx = Math.max(jobDifficulty[k], mx);
                        f[i][j] = Math.min(f[i][j], f[i - 1][k - 1] + mx);
                    }
                }
            }
            return f[d-1][n-1];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       