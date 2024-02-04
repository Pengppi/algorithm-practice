/**
 * @Title: 1690.石子游戏 VII
 * @TitleSlug: stoneGameVii
 * @Author: Neo
 * @Date: 2024-02-03 18:33:01
 */
package leetcode.editor.cn;

public class 石子游戏VII {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 石子游戏VII().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] sum, stones;
        int[][] memo;
        
        public int stoneGameVII(int[] stones) {
            this.stones = stones;
            int n = stones.length;
            sum = new int[n + 1];
            memo = new int[n][n];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + stones[i];
            }
            return dfs(0, n - 1);
        }
        
        private int dfs(int l, int r) {
            if (l == r) {
                return 0;
            }
            if (memo[l][r] != 0) {
                return memo[l][r];
            }
            int res1 = sum[r] - sum[l] - dfs(l, r - 1);
            int res2 = sum[r + 1] - sum[l + 1] - dfs(l + 1, r);
            return memo[l][r] = Math.max(res1, res2);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       