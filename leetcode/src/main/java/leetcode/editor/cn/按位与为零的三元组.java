/**
 * @Title: 982.按位与为零的三元组
 * @TitleSlug: triplesWithBitwiseAndEqualToZero
 * @Author: Neo
 * @Date: 2023-03-04 15:09:39
 */
package leetcode.editor.cn;

public class 按位与为零的三元组 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 按位与为零的三元组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTriplets(int[] nums) {
            int[] cnt = new int[1 << 16];
            for (int i : nums) {
                for (int j : nums) {
                    cnt[i & j]++;
                }
            }
            int ans = 0;
            for (int i = 0; i < 1 << 16; i++) {
                for (int k : nums) {
                    if ((i & k) == 0) {
                        ans += cnt[i];
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
