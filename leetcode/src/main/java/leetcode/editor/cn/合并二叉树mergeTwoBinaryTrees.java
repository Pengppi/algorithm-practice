/**
 * @Title: 617.合并二叉树
 * @TitleSlug: mergeTwoBinaryTrees
 * @Author: Neo
 * @Date: 2024-04-27 23:46:38
 */
package leetcode.editor.cn;

import entity.TreeNode;

public class 合并二叉树mergeTwoBinaryTrees {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 合并二叉树mergeTwoBinaryTrees().new Solution();
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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            } else if (root1 == null) {
                return root2;
            } else if (root2 == null) {
                return root1;
            } else {
                TreeNode node = new TreeNode(root1.val + root2.val);
                node.left = mergeTrees(root1.left, root2.left);
                node.right = mergeTrees(root1.right, root2.right);
                return node;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       