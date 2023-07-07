/**
 * @Title: 2367.算术三元组的数目
 * @TitleSlug: numberOfArithmeticTriplets
 * @Author: Neo
 * @Date: 2023-03-31 15:35:19
 */
package leetcode.editor.cn;

public class 算术三元组的数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 算术三元组的数目().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arithmeticTriplets(int[] nums, int diff) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    if (nums[j] - nums[i] == diff) {
                        for (int k = j + 1; k < n; k++) {
                            if (nums[k] - nums[j] == diff) {
                                ans++;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
