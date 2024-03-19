/**
 * @Title: 98.验证二叉搜索树
 * @TitleSlug: validateBinarySearchTree
 * @Author: Neo
 * @Date: 2024-03-19 19:50:09
 */
package leetcode.editor.cn;

import entity.TreeNode;

public class 验证二叉搜索树validateBinarySearchTree {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 验证二叉搜索树validateBinarySearchTree().new Solution();
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
        long pre = Long.MIN_VALUE;
        
        public boolean isValidBST(TreeNode root) {
            return dfs(root);
        }
        
        private boolean dfs(TreeNode node) {
            if (node == null) {
                return true;
            }
            if (!dfs(node.left)) {
                return false;
            }
            if (node.val <= pre) {
                return false;
            }
            pre = node.val;
            return dfs(node.right);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       