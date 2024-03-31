/**
 * @Title: 2952.需要添加的硬币的最小数量
 * @TitleSlug: minimumNumberOfCoinsToBeAdded
 * @Author: Neo
 * @Date: 2024-03-30 00:01:52
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 需要添加的硬币的最小数量minimumNumberOfCoinsToBeAdded {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 需要添加的硬币的最小数量minimumNumberOfCoinsToBeAdded().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumAddedCoins(int[] coins, int target) {
            Arrays.sort(coins);
            int ans = 0, cur = 1, i = 0;
            while (cur <= target) {
                if (i < coins.length && coins[i] <= cur) {
                    cur += coins[i];
                    i++;
                } else {
                    cur += cur;
                    ans++;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}
       