/**
 * @Title: 746.使用最小花费爬楼梯
 * @TitleSlug: minCostClimbingStairs
 * @Author: Neo
 * @Date: 2023-10-16 23:39:17
 */
package leetcode.editor.cn;

public class 使用最小花费爬楼梯 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 使用最小花费爬楼梯().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] f = new int[n];
            f[0] = cost[0];
            f[1] = cost[1];
            for (int i = 2; i < n; i++) {
                f[i] = Math.min(f[i - 2], f[i - 1]) + cost[i];
            }
            return Math.min(f[n - 1], f[n - 2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       