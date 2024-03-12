/**
 * @Title: 1261.在受污染的二叉树中查找元素
 * @TitleSlug: findElementsInAContaminatedBinaryTree
 * @Author: Neo
 * @Date: 2024-03-12 00:30:34
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class 在受污染的二叉树中查找元素findElementsInAContaminatedBinaryTree {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 在受污染的二叉树中查找元素findElementsInAContaminatedBinaryTree().new Solution();
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
    class FindElements {
        
        Set<Integer> set;
        
        public FindElements(TreeNode root) {
            set = new HashSet<>();
            root.val = 0;
            recover(root);
        }
        
        private void recover(TreeNode root) {
            set.add(root.val);
            if (root.left != null) {
                root.left.val = 2 * root.val + 1;
                recover(root.left);
            }
            if (root.right != null) {
                root.right.val = 2 * root.val + 2;
                recover(root.right);
            }
        }
        
        public boolean find(int target) {
            return set.contains(target);
        }
    }
    
    /**
     * Your FindElements object will be instantiated and called as such:
     * FindElements obj = new FindElements(root);
     * boolean param_1 = obj.find(target);
     */
// leetcode submit region end(Prohibit modification and deletion)
    private class TreeNode {
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
       