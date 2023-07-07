/**
 * @Title: 剑指 Offer 57.和为s的两个数字
 * @TitleSlug: heWeiSdeLiangGeShuZiLcof
 * @Author: Neo
 * @Date: 2023-05-12 14:40:11
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 和为s的两个数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 和为s的两个数字().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    return new int[]{nums[l], nums[r]};
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
            return new int[0];

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       