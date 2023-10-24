/**
 * @Title: 1155.掷骰子等于目标和的方法数
 * @TitleSlug: numberOfDiceRollsWithTargetSum
 * @Author: Neo
 * @Date: 2023-10-24 11:56:29
 */
package leetcode.editor.cn;

public class 掷骰子等于目标和的方法数 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 掷骰子等于目标和的方法数().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        final int MOD = (int) 1e+9 + 7;
        int ans = 0;

        public int numRollsToTarget(int n, int k, int target) {
            if (target < n || target > n * k) {
                return 0;
            }
            int[][] f = new int[n + 1][target - n + 1];
            f[0][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= target - n; j++) {
                    for (int x = 0; x < k && x <= j; x++) {
                        f[i][j] = (f[i][j] + f[i - 1][j - x]) % MOD;
                    }
                }
            }
            return f[n][target - n];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       