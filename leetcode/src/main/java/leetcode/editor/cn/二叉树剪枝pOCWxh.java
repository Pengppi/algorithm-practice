/**
 * @Title: LCR 047.二叉树剪枝
 * @TitleSlug: pOCWxh
 * @Author: Neo
 * @Date: 2024-03-20 18:50:55
 */
package leetcode.editor.cn;

import entity.TreeNode;

public class 二叉树剪枝pOCWxh {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树剪枝pOCWxh().new Solution();
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
        public TreeNode pruneTree(TreeNode root) {
            return containsOne(root) ? root : null;
        }
        
        private boolean containsOne(TreeNode node) {
            if (node == null) {
                return false;
            }
            boolean leftContains = containsOne(node.left);
            boolean rightContains = containsOne(node.right);
            if (!leftContains) {
                node.left = null;
            }
            if (!rightContains) {
                node.right = null;
            }
            return node.val == 1 || leftContains || rightContains;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
    
}
       