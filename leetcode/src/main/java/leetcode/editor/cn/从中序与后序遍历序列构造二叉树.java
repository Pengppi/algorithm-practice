/**
 * @Title: 106.从中序与后序遍历序列构造二叉树
 * @TitleSlug: constructBinaryTreeFromInorderAndPostorderTraversal
 * @Author: Neo
 * @Date: 2024-02-21 09:15:17
 */
package leetcode.editor.cn;

public class 从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 从中序与后序遍历序列构造二叉树().new Solution();
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
            return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
        }
        
        private TreeNode buildTree(final int i1, final int j1, final int i2, final int j2) {
            if (i1 > j1 || i2 > j2) {
                return null;
            }
            int rootVal = postorder[j2];
            int rootIndex = i1;
            while (rootIndex < j1 && inorder[rootIndex] != rootVal) {
                rootIndex++;
            }
            TreeNode root = new TreeNode(rootVal);
            int leftSize = rootIndex - i1;
            root.left = buildTree(i1, rootIndex - 1, i2, i2 + leftSize - 1);
            root.right = buildTree(rootIndex + 1, j1, i2 + leftSize, j2 - 1);
            return root;
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
        }
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
        
       