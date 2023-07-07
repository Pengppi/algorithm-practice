/**
 * @Title: 剑指 Offer 28.对称的二叉树
 * @TitleSlug: duiChengDeErChaShuLcof
 * @Author: Neo
 * @Date: 2023-04-30 14:42:52
 */
package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

public class 对称的二叉树 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 对称的二叉树().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isEqual(root.left, root.right);
        }

        public Boolean isEqual(TreeNode l, TreeNode r) {
            if (l == null && r == null)
                return true;
            else if (l == null || r == null)
                return false;
            if (l.val != r.val)
                return false;
            return isEqual(l.left, r.right) && isEqual(l.right, r.left);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       