/**
 * @Title: 112.路径总和
 * @TitleSlug: pathSum
 * @Author: Neo
 * @Date: 2023-12-29 14:07:03
 */
package leetcode.editor.cn;

public class 路径总和 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 路径总和().new Solution();
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            return dfs(root, targetSum);
        }

        private boolean dfs(TreeNode node, int targetSum) {
            if (node == null) {
                return targetSum == 0;
            }
            int t = targetSum - node.val;
            if (node.left != null && node.right != null) {
                return dfs(node.left, t) || dfs(node.right, t);
            } else if (node.left != null) {
                return dfs(node.left, t);
            } else {
                return dfs(node.right, t);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
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
        
       