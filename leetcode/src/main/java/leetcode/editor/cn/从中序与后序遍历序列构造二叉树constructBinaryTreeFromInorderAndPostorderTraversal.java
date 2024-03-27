/**
 * @Title: 106.从中序与后序遍历序列构造二叉树
 * @TitleSlug: constructBinaryTreeFromInorderAndPostorderTraversal
 * @Author: Neo
 * @Date: 2024-03-27 09:21:45
 */
package leetcode.editor.cn;

import entity.TreeNode;

public class 从中序与后序遍历序列构造二叉树constructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 从中序与后序遍历序列构造二叉树constructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        private int[] inorder, postorder;
        
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;
            return build(0, inorder.length - 1, 0, postorder.length - 1);
        }
        
        private TreeNode build(int i1, int j1, int i2, int j2) {
            if (i1 > j1) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[j2]);
            int k = i1;
            while (inorder[k] != postorder[j2]) {
                k++;
            }
            int leftSize = k - i1;
            root.left = build(i1, k - 1, i2, i2 + leftSize - 1);
            root.right = build(k + 1, j1, i2 + leftSize, j2 - 1);
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       