/**
 * @Title: 377.组合总和 Ⅳ
 * @TitleSlug: combinationSumIv
 * @Author: Neo
 * @Date: 2024-04-22 00:50:06
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 组合总和ⅣcombinationSumIv {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 组合总和ⅣcombinationSumIv().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] memo;
        
        public int combinationSum4(int[] nums, int target) {
            memo = new int[target + 1];
            Arrays.fill(memo, -1);
            return backTracking(nums, target);
        }
        
        private int backTracking(int[] nums, int target) {
            if (target <= 0) {
                if (target == 0) {
                    return 1;
                }
                return 0;
            }
            if (memo[target] != -1) {
                return memo[target];
            }
            int res = 0;
            for (int num : nums) {
                res += backTracking(nums, target - num);
            }
            return memo[target] = res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       