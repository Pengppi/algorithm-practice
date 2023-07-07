/**
 * @Title: 1027.最长等差数列
 * @TitleSlug: longestArithmeticSubsequence
 * @Author: Neo
 * @Date: 2023-04-22 12:18:33
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 最长等差数列 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最长等差数列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            int n = nums.length;
            int[][] f = new int[n][1005];
            for (int i = 0; i < n; i++) {
                Arrays.fill(f[i], 1);
            }
            int ans = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int d = nums[i] - nums[j] + 500;
                    f[i][d] = Math.max(f[i][d], f[j][d] + 1);
                    ans = Math.max(ans, f[i][d]);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       