/**
 * @Title: 105.从前序与中序遍历序列构造二叉树
 * @TitleSlug: constructBinaryTreeFromPreorderAndInorderTraversal
 * @Author: Neo
 * @Date: 2024-02-02 18:59:29
 */
package leetcode.editor.cn;

public class 从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 从前序与中序遍历序列构造二叉树().new Solution();
        solution.buildTree(new int[]{3, 2, 1, 4}, new int[]{1, 2, 3, 4});
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
        private int[] pre, in;
        
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            pre = preorder;
            in = inorder;
            int n = inorder.length;
            return buildTree(0, n - 1, 0, n - 1);
        }
        
        private TreeNode buildTree(int i1, int j1, int i2, int j2) {
            if (i1 > j1 || i2 > j2) {
                return null;
            }
            int rtIdx = i2;
            while (rtIdx <= j2 && pre[i1] != in[rtIdx]) {
                rtIdx++;
            }
            TreeNode root = new TreeNode(in[rtIdx]);
            int leftSize = rtIdx - i2;
            root.left = buildTree(i1 + 1, i1 + leftSize, i2, rtIdx - 1);
            root.right = buildTree(i1 + 1 + leftSize, j1, rtIdx + 1, j2);
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
        
       