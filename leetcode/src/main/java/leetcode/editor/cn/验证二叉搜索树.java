/**
 * @Title: 98.验证二叉搜索树
 * @TitleSlug: validateBinarySearchTree
 * @Author: Neo
 * @Date: 2023-05-20 13:52:26
 */
package leetcode.editor.cn;

public class 验证二叉搜索树 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 验证二叉搜索树().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
            return f(root);
        }

        private boolean f(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!f(root.left)) {
                return false;
            }
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            return f(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       