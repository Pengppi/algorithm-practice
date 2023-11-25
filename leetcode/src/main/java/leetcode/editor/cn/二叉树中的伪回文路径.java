/**
 * @Title: 1457.二叉树中的伪回文路径
 * @TitleSlug: pseudoPalindromicPathsInABinaryTree
 * @Author: Neo
 * @Date: 2023-11-25 12:39:54
 */
package leetcode.editor.cn;

public class 二叉树中的伪回文路径 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 二叉树中的伪回文路径().new Solution();
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
        public int pseudoPalindromicPaths(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode root, int mask) {
            if (root == null) {
                return 0;
            }
            int x = root.val;
            mask ^= 1 << x;
            if (root.left == null && root.right == null) {
                return (mask & (mask - 1)) == 0 ? 1 : 0;
            }
            return dfs(root.left, mask) + dfs(root.right, mask);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       