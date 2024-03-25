/**
 * @Title: 137.只出现一次的数字 II
 * @TitleSlug: singleNumberIi
 * @Author: Neo
 * @Date: 2024-03-25 08:54:31
 */
package leetcode.editor.cn;

public class 只出现一次的数字IIsingleNumberIi {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 只出现一次的数字IIsingleNumberIi().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] arr = new int[32];
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int mask = 1 << i;
                for (int num : nums) {
                    if ((num & mask) != 0) {
                        arr[i]++;
                    }
                }
                if (arr[i] % 3 != 0) {
                    ans |= mask;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       