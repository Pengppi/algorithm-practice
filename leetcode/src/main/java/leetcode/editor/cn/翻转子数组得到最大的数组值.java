/**
 * @Title: 1330.翻转子数组得到最大的数组值
 * @TitleSlug: reverseSubarrayToMaximizeArrayValue
 * @Author: Neo
 * @Date: 2023-05-12 00:15:11
 */
package leetcode.editor.cn;

public class 翻转子数组得到最大的数组值 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 翻转子数组得到最大的数组值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValueAfterReverse(int[] nums) {
            int n = nums.length;
            int base = 0, d = 0;
            int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                int a = nums[i - 1], b = nums[i];
                int dab = Math.abs(a - b);
                base += dab;
                mx = Math.max(mx, Math.min(a, b));
                mn = Math.min(mn, Math.max(a, b));
                d = Math.max(d, Math.max(Math.abs(nums[0] - b) - dab, Math.abs(nums[n - 1] - a) - dab));
            }
            return base + Math.max(d, (mx - mn) * 2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       