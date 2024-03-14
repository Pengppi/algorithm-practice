/**
 * @Title: 2789.合并后数组中的最大元素
 * @TitleSlug: largestElementInAnArrayAfterMergeOperations
 * @Author: Neo
 * @Date: 2024-03-14 00:42:54
 */
package leetcode.editor.cn;

public class 合并后数组中的最大元素largestElementInAnArrayAfterMergeOperations {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 合并后数组中的最大元素largestElementInAnArrayAfterMergeOperations().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxArrayValue(int[] nums) {
            int n = nums.length;
            long[] f = new long[n];
            f[n - 1] = nums[n - 1];
            long ans = f[n - 1];
            for (int i = n - 1; i > 0; i--) {
                f[i - 1] = nums[i - 1];
                if (f[i] >= f[i - 1]) {
                    f[i - 1] += f[i];
                }
                ans = Math.max(ans, f[i - 1]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       