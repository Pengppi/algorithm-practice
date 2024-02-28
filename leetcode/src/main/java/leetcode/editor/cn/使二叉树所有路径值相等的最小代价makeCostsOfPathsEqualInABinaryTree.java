/**
 * @Title: 2673.使二叉树所有路径值相等的最小代价
 * @TitleSlug: makeCostsOfPathsEqualInABinaryTree
 * @Author: Neo
 * @Date: 2024-02-28 09:16:17
 */
package leetcode.editor.cn;

public class 使二叉树所有路径值相等的最小代价makeCostsOfPathsEqualInABinaryTree {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 使二叉树所有路径值相等的最小代价makeCostsOfPathsEqualInABinaryTree().new Solution();
    }
    
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minIncrements(int n, int[] cost) {
            int ans = 0;
            for (int i = n / 2; i > 0; i--) {
                ans += Math.abs(cost[2 * i - 1] - cost[2 * i]);
                cost[i - 1] += Math.max(cost[2 * i - 1], cost[2 * i]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       