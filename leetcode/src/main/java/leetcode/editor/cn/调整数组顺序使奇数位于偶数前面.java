/**
 * @Title: 剑指 Offer 21.调整数组顺序使奇数位于偶数前面
 * @TitleSlug: diaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof
 * @Author: Neo
 * @Date: 2023-05-31 15:03:50
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 调整数组顺序使奇数位于偶数前面().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                while (l < r && nums[l] % 2 != 0) {
                    l++;
                }
                while (l < r && nums[r] % 2 == 0) {
                    r--;
                }
                swap(nums, l, r);
            }
            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       