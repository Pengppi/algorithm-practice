/**
 * @Title: 162.寻找峰值
 * @TitleSlug: findPeakElement
 * @Author: Neo
 * @Date: 2023-11-05 17:49:50
 */
package leetcode.editor.cn;

public class 寻找峰值 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 寻找峰值().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (m + 1 < nums.length && nums[m] < nums[m + 1]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }

        public int f1(int[] nums) {
            int ans = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[ans]) {
                    ans = i;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       