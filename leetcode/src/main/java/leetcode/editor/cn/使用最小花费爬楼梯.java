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
            int f1 = cost[0], f2 = cost[1];
            for (int i = 2; i < n; i++) {
                int f3 = Math.min(f1, f2) + cost[i];
                f1 = f2;
                f2 = f3;
            }
            return Math.min(f1, f2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       