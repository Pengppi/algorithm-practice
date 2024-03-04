/**
 * @Title: 236.二叉树的最近公共祖先
 * @TitleSlug: lowestCommonAncestorOfABinaryTree
 * @Author: Neo
 * @Date: 2024-03-04 20:50:44
 */
package leetcode.editor.cn;

public class 二叉树的最近公共祖先lowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树的最近公共祖先lowestCommonAncestorOfABinaryTree().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return root;
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
}
       