/**
 * @Title: 1444.切披萨的方案数
 * @TitleSlug: numberOfWaysOfCuttingAPizza
 * @Author: Neo
 * @Date: 2024-03-28 18:46:36
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 切披萨的方案数numberOfWaysOfCuttingAPizza {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 切披萨的方案数numberOfWaysOfCuttingAPizza().new Solution();
        String[] pizza = {"A..", "AAA", "..."};
        int k = 3;
        System.out.println(solution.ways(pizza, k));
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int MOD = 1_000_000_007;
        private int[][] preSum;
        private int[][][] memo;
        private int m, n;
        
        public int ways(String[] pizza, int k) {
            m = pizza.length;
            n = pizza[0].length();
            preSum = new int[m + 1][n + 1];
            memo = new int[m][n][k - 1];
            for (int i = 0; i < m; i++) {
                String s = pizza[i];
                for (int j = 0; j < n; j++) {
                    preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + (s.charAt(j) == 'A' ? 1 : 0);
                    Arrays.fill(memo[i][j], -1);
                }
            }
            return dfs(0, 0, k - 1);
        }
        
        private int dfs(int x, int y, int k) {
            if (k == 0) {
                return preSum[m][n] - preSum[x][n] - preSum[m][y] + preSum[x][y] > 0 ? 1 : 0;
            }
            if (memo[x][y][k - 1] != -1) {
                return memo[x][y][k - 1];
            }
            int res = 0;
            for (int i = x + 1; i < m; i++) {
                int rowSum = preSum[i][n] - preSum[i][y] - preSum[x][n] + preSum[x][y];
                if (rowSum > 0) {
                    res = (res + dfs(i, y, k - 1)) % MOD;
                }
            }
            for (int j = y + 1; j < n; j++) {
                int colSum = preSum[m][j] - preSum[m][y] - preSum[x][j] + preSum[x][y];
                if (colSum > 0) {
                    res = (res + dfs(x, j, k - 1)) % MOD;
                }
            }
            return memo[x][y][k - 1] = res;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       