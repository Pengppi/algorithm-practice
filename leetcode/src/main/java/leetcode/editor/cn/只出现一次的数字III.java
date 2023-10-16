/**
 * @Title: 260.只出现一次的数字 III
 * @TitleSlug: singleNumberIii
 * @Author: Neo
 * @Date: 2023-10-16 00:05:55
 */
package leetcode.editor.cn;

public class 只出现一次的数字III {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 只出现一次的数字III().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            int t = 0;
            for (int num : nums) {
                t ^= num;
            }
            t = t & -t;
            int[] ans = new int[2];
            for (int num : nums) {
                ans[(num & t) == 0 ? 0 : 1] ^= num;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       