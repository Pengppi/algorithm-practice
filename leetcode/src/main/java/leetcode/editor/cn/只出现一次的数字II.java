/**
 * @Title: 137.只出现一次的数字 II
 * @TitleSlug: singleNumberIi
 * @Author: Neo
 * @Date: 2023-10-15 14:03:03
 */
package leetcode.editor.cn;

public class 只出现一次的数字II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 只出现一次的数字II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int cnt = 0;
                for (int x : nums) {
                    cnt += x >> i & 1;
                }
                ans |= cnt % 3 << i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       