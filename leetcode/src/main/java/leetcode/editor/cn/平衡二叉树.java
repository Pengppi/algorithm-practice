/**
 * @Title: 剑指 Offer 55 - II.平衡二叉树
 * @TitleSlug: pingHengErChaShuLcof
 * @Author: Neo
 * @Date: 2023-05-14 14:54:31
 */
package leetcode.editor.cn;

import javax.annotation.Resource;
import javax.swing.tree.TreeNode;

public class 平衡二叉树 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 平衡二叉树().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            return getDepth(root) != -1;
        }

        private int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = getDepth(root.left);
            int r = getDepth(root.right);
            if (l == -1) {
                return -1;
            }
            if (r == -1) {
                return -1;
            }
            if (Math.abs(l - r) > 1) {
                return -1;
            }
            return 1 + Math.max(getDepth(root.left), getDepth(root.right));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       