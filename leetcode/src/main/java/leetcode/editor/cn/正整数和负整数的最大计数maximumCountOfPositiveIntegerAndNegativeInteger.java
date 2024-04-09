/**
 * @Title: 2529.正整数和负整数的最大计数
 * @TitleSlug: maximumCountOfPositiveIntegerAndNegativeInteger
 * @Author: Neo
 * @Date: 2024-04-09 01:07:03
 */
package leetcode.editor.cn;

public class 正整数和负整数的最大计数maximumCountOfPositiveIntegerAndNegativeInteger {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 正整数和负整数的最大计数maximumCountOfPositiveIntegerAndNegativeInteger().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumCount(int[] nums) {
            int n = nums.length;
            int l = -1, r = n;
            while (l + 1 < r) {
                int mid = (l + r) >> 1;
                if (nums[mid] < 1) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            while (l >= 0 && nums[l] == 0) {
                l--;
            }
            return Math.max(l + 1, n - r);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       