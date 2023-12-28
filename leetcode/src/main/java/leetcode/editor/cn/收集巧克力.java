/**
 * @Title: 2735.收集巧克力
 * @TitleSlug: collectingChocolates
 * @Author: Neo
 * @Date: 2023-12-28 16:19:47
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 收集巧克力 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 收集巧克力().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minCost(int[] nums, int x) {
            int n = nums.length;
            int[] cost = Arrays.copyOf(nums, n);
            long ans = getSum(nums);
            for (int k = 1; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    cost[i] = Math.min(cost[i], nums[(i + k) % n]);
                }
                ans = Math.min(ans, (long) k * x + getSum(cost));
            }
            return ans;
        }

        private long getSum(int[] nums) {
            long res = 0;
            for (int num : nums) {
                res += num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       