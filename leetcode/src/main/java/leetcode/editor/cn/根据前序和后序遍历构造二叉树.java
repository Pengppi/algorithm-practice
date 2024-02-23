/**
 * @Title: 889.根据前序和后序遍历构造二叉树
 * @TitleSlug: constructBinaryTreeFromPreorderAndPostorderTraversal
 * @Author: Neo
 * @Date: 2024-02-22 20:32:48
 */
package leetcode.editor.cn;

public class 根据前序和后序遍历构造二叉树 {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 根据前序和后序遍历构造二叉树().new Solution();
        solution.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7},
                new int[]{4, 5, 2, 6, 7, 3, 1});
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
        int[] preorder, postorder;
        
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            this.preorder = preorder;
            this.postorder = postorder;
            return buildTree(0, preorder.length - 1, 0, postorder.length - 1);
        }
        
        private TreeNode buildTree(final int i1, final int j1, final int i2, final int j2) {
            if (i1 > j1 || i2 > j2) {
                return null;
            }
            if (i1 == j1 || i2 == j2) {
                return new TreeNode(preorder[i1]);
            }
            int leftRootIndexInPost = i2;
            while (leftRootIndexInPost < j2 && postorder[leftRootIndexInPost] != preorder[i1 + 1]) {
                leftRootIndexInPost++;
            }
            int leftTreeSize = leftRootIndexInPost - i2 + 1;
            TreeNode root = new TreeNode(preorder[i1]);
            root.left = buildTree(i1 + 1, i1 + leftTreeSize, i2, i2 + leftTreeSize - 1);
            root.right = buildTree(i1 + leftTreeSize + 1, j1, i2 + leftTreeSize, j2 - 1);
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
        
       