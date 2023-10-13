/**
 * @Title: 136.只出现一次的数字
 * @TitleSlug: singleNumber
 * @Author: Neo
 * @Date: 2023-10-13 16:04:05
 */
package leetcode.editor.cn;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 只出现一次的数字().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                ans ^= nums[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       