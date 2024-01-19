/**
 * @Title: 129.求根节点到叶节点数字之和
 * @TitleSlug: sumRootToLeafNumbers
 * @Author: Neo
 * @Date: 2024-01-19 16:04:51
 */
package leetcode.editor.cn;

public class 求根节点到叶节点数字之和 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 求根节点到叶节点数字之和().new Solution();
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
        public int sumNumbers(TreeNode root) {
            return sumNumbers(root, 0);
        }
        
        private int sumNumbers(TreeNode node, int x) {
            if (node == null) {
                return 0;
            }
            x = x * 10 + node.val;
            if (node.left != null && node.right != null) {
                return sumNumbers(node.left, x) + sumNumbers(node.right, x);
            } else if (node.left != null) {
                return sumNumbers(node.left, x);
            } else if (node.right != null) {
                return sumNumbers(node.right, x);
            } else {
                return x;
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
        
       