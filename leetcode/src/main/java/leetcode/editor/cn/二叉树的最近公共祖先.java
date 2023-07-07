/**
 * @Title: 剑指 Offer 68 - II.二叉树的最近公共祖先
 * @TitleSlug: erChaShuDeZuiJinGongGongZuXianLcof
 * @Author: Neo
 * @Date: 2023-05-18 14:10:08
 */
package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉树的最近公共祖先().new Solution();
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);
            if (l == null) {
                return r;
            }
            if (r == null) {
                return l;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       