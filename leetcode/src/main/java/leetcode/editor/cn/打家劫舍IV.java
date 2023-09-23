/**
 * @Title: 2560.打家劫舍 IV
 * @TitleSlug: houseRobberIv
 * @Author: Neo
 * @Date: 2023-09-19 00:30:54
 */
package leetcode.editor.cn;

public class 打家劫舍IV {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 打家劫舍IV().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCapability(int[] nums, int k) {
            int left = 0, right = 0;
            for (int x : nums) {
                right = Math.max(right, x);
            }
            while (left + 1 < right) { // 开区间写法
                int mid = (left + right) >>> 1;
                if (check(nums, k, mid)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }

        private boolean check(int[] nums, int k, int mx) {
            int f0 = 0, f1 = 0;
            for (int x : nums) {
                if (x > mx) {
                    f0 = f1;
                } else {
                    int tmp = f1;
                    f1 = Math.max(f1, f0 + 1);
                    f0 = tmp;
                }
            }
            return f1 >= k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       