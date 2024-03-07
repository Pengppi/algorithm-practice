/**
 * @Title: 173.二叉搜索树迭代器
 * @TitleSlug: binarySearchTreeIterator
 * @Author: Neo
 * @Date: 2024-03-06 17:24:56
 */
package leetcode.editor.cn;

import java.util.LinkedList;

public class 二叉搜索树迭代器binarySearchTreeIterator {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉搜索树迭代器binarySearchTreeIterator().new Solution();
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
    class BSTIterator {
        LinkedList<Integer> list;
        
        public BSTIterator(TreeNode root) {
            list = new LinkedList<>();
            inorder(root, list);
        }
        
        private void inorder(TreeNode root, LinkedList<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
        
        public int next() {
            return list.pollFirst();
        }
        
        public boolean hasNext() {
            return !list.isEmpty();
        }
    }
    
    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
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
       