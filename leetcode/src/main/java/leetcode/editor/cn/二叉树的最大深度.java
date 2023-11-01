/**
 * @Title: 104.二叉树的最大深度
 * @TitleSlug: maximumDepthOfBinaryTree
 * @Author: Neo
 * @Date: 2023-11-01 16:24:50
 */
package leetcode.editor.cn;

public class 二叉树的最大深度 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉树的最大深度().new Solution();
    }

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
    //leetcode submit region begin(Prohibit modification and deletion)

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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       