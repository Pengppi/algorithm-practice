/**
 * @Title: 283.移动零
 * @TitleSlug: moveZeroes
 * @Author: Neo
 * @Date: 2023-10-10 22:35:52
 */
package leetcode.editor.cn;

public class 移动零 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 移动零().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int l = 0;
            for (int num : nums) {
                if (num != 0) {
                    nums[l++] = num;
                }
            }
            while (l < nums.length) {
                nums[l++] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       