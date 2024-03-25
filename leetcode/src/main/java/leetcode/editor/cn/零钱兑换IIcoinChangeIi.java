/**
 * @Title: 518.零钱兑换 II
 * @TitleSlug: coinChangeIi
 * @Author: Neo
 * @Date: 2024-03-25 00:24:14
 */
package leetcode.editor.cn;

public class 零钱兑换IIcoinChangeIi {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 零钱兑换IIcoinChangeIi().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            int[] f = new int[amount + 1];
            f[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    f[i] += f[i - coin];
                }
            }
            return f[amount];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       