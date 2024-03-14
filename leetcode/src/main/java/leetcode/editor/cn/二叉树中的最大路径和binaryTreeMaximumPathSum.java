/**
 * @Title: 124.二叉树中的最大路径和
 * @TitleSlug: binaryTreeMaximumPathSum
 * @Author: Neo
 * @Date: 2024-03-14 09:26:57
 */
package leetcode.editor.cn;

import entity.TreeNode;

public class 二叉树中的最大路径和binaryTreeMaximumPathSum {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树中的最大路径和binaryTreeMaximumPathSum().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int ans = Integer.MIN_VALUE;
        
        public int maxPathSum(TreeNode root) {
            dfs(root);
            return ans;
        }
        
        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, dfs(root.left));
            int right = Math.max(0, dfs(root.right));
            ans = Math.max(ans, root.val + left + right);
            return root.val + Math.max(left, right);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       