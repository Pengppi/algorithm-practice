/**
 * @Title: LCR 054.把二叉搜索树转换为累加树
 * @TitleSlug: w6cpku
 * @Author: Neo
 * @Date: 2024-04-09 01:40:03
 */
package leetcode.editor.cn;

import entity.TreeNode;

public class 把二叉搜索树转换为累加树w6cpku {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 把二叉搜索树转换为累加树w6cpku().new Solution();
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
        private int sum = 0;
        
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
            return root;
        }
        
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       