/**
 * @Title: 213.打家劫舍 II
 * @TitleSlug: houseRobberIi
 * @Author: Neo
 * @Date: 2023-09-17 00:24:40
 */
package leetcode.editor.cn;

public class 打家劫舍II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 打家劫舍II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            if (n == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(P198_rob(nums, 0, n - 2), P198_rob(nums, 1, n - 1));
        }

        private int P198_rob(int[] nums, int l, int r) {
            int a = 0, b = nums[l];
            for (int i = l + 1; i <= r; i++) {
                int c = Math.max(b, a + nums[i]);
                a = b;
                b = c;
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       