/**
 * @Title: 322.零钱兑换
 * @TitleSlug: coinChange
 * @Author: Neo
 * @Date: 2024-03-09 13:05:40
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 零钱兑换coinChange {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 零钱兑换coinChange().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] f = new int[amount + 1];
            Arrays.fill(f, -1);
            f[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i >= coin && f[i - coin] != -1) {
                        if (f[i] == -1 || f[i] > f[i - coin] + 1) {
                            f[i] = f[i - coin] + 1;
                        }
                    }
                }
            }
            return f[amount];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       