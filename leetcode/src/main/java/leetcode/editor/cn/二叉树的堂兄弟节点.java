/**
 * @Title: 993.二叉树的堂兄弟节点
 * @TitleSlug: cousinsInBinaryTree
 * @Author: Neo
 * @Date: 2024-02-08 12:14:57
 */
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉树的堂兄弟节点 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树的堂兄弟节点().new Solution();
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
        public boolean isCousins(TreeNode root, int x, int y) {
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int xFa = -1, yFa = -1;
            while (!queue.isEmpty()) {
                xFa = -1;
                yFa = -1;
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                        if (node.left.val == x) {
                            xFa = node.val;
                        }
                        if (node.left.val == y) {
                            yFa = node.val;
                        }
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                        if (node.right.val == x) {
                            xFa = node.val;
                        }
                        if (node.right.val == y) {
                            yFa = node.val;
                        }
                    }
                }
                if (xFa != -1 && yFa != -1) {
                    return xFa != yFa;
                } else if (xFa != -1 || yFa != -1) {
                    return false;
                }
            }
            return false;
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
        
       