/**
 * @Title: 2679.矩阵中的和
 * @TitleSlug: sumInAMatrix
 * @Author: Neo
 * @Date: 2023-07-10 19:09:54
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 矩阵中的和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 矩阵中的和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int matrixSum(int[][] nums) {
            int m = nums.length;
            int n = nums[0].length;
            int ans = 0;
            for (int[] num : nums) {
                Arrays.sort(num);
            }
            for (int i = 0; i < n; i++) {
                int mx = 0;
                for (int j = 0; j < m; j++) {
                    mx = Math.max(mx, nums[j][i]);
                }
                ans+=mx;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       