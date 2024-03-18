/**
 * @Title: 162.寻找峰值
 * @TitleSlug: findPeakElement
 * @Author: Neo
 * @Date: 2024-03-18 09:15:05
 */
package leetcode.editor.cn;

public class 寻找峰值findPeakElement {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 寻找峰值findPeakElement().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            int n = nums.length;
            int l = -1, r = n;
            while (l + 1 < r) {
                int m = l + ((r - l) >> 1);
                if (m + 1 < n && nums[m] < nums[m + 1]) {
                    l = m;
                } else {
                    r = m;
                }
            }
            return r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       