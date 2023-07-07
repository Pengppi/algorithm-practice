/**
 * @Title: 775.全局倒置与局部倒置
 * @TitleSlug: GlobalAndLocalInversions
 * @Author: Neo
 * @Date: 2022-11-16 10:10:53
 */
package leetcode.editor.cn;

public class 全局倒置与局部倒置 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 全局倒置与局部倒置().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            int n = nums.length;
            int mn = nums[n - 1];
            for (int i = n - 3; i >= 0; i--) {
                if (nums[i] > mn) {
                    return false;
                }
                mn = Math.min(mn, nums[i + 1]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
