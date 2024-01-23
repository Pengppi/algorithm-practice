/**
 * @Title: 101.对称二叉树
 * @TitleSlug: symmetricTree
 * @Author: Neo
 * @Date: 2024-01-22 23:28:29
 */
package leetcode.editor.cn;

public class 对称二叉树 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 对称二叉树().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root.left, root.right);
            
        }
        
        private boolean isSymmetric(final TreeNode left, final TreeNode right) {
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
            } else if (left == null && right == null) {
                return true;
            } else {
                return false;
            }
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
        
       