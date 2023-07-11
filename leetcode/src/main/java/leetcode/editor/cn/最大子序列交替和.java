/**
 * @Title: 1911.最大子序列交替和
 * @TitleSlug: maximumAlternatingSubsequenceSum
 * @Author: Neo
 * @Date: 2023-07-11 17:45:49
 */
package leetcode.editor.cn;

public class 最大子序列交替和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最大子序列交替和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxAlternatingSum(int[] nums) {
            int n = nums.length;
            long[][] d = new long[n][2];
            d[0][0] = nums[0];
            for (int i = 1; i < n; i++) {
                d[i][0] = Math.max(d[i - 1][0], nums[i] + Math.max(0, d[i - 1][1]));
                d[i][1] = Math.max(d[i - 1][1], d[i - 1][0] - nums[i]);
            } 
            return Math.max(d[n - 1][0], d[n - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       