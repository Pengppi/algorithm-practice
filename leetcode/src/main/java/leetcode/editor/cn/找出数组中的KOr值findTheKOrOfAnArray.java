/**
 * @Title: 2917.找出数组中的 K-or 值
 * @TitleSlug: findTheKOrOfAnArray
 * @Author: Neo
 * @Date: 2024-03-06 00:30:40
 */
package leetcode.editor.cn;

public class 找出数组中的KOr值findTheKOrOfAnArray {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 找出数组中的KOr值findTheKOrOfAnArray().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKOr(int[] nums, int k) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int mask = 1 << i, cnt = 0;
                for (int num : nums) {
                    if ((num & mask) != 0) {
                        cnt++;
                    }
                    if (cnt >= k) {
                        ans |= mask;
                        break;
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       