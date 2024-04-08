/**
 * @Title: 2009.使数组连续的最少操作数
 * @TitleSlug: minimumNumberOfOperationsToMakeArrayContinuous
 * @Author: Neo
 * @Date: 2024-04-08 00:47:18
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 使数组连续的最少操作数minimumNumberOfOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 使数组连续的最少操作数minimumNumberOfOperationsToMakeArrayContinuous().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int m = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[m++] = nums[i];
                }
            }
            int left = 0, ans = 0;
            for (int i = 0; i < m; i++) {
                while (nums[left] < nums[i] - n + 1) {
                    left++;
                }
                ans = Math.max(ans, i - left + 1);
            }
            return n - ans;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       