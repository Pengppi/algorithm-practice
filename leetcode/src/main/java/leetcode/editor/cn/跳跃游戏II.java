/**
 * @Title: 45.跳跃游戏 II
 * @TitleSlug: jumpGameIi
 * @Author: Neo
 * @Date: 2024-02-15 13:01:59
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 跳跃游戏II {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 跳跃游戏II().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int[] f = new int[n + 1];
            Arrays.fill(f, Integer.MAX_VALUE);
            f[0] = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (j + nums[j] >= i) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
            return f[n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
        
       