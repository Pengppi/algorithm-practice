/**
 * @Title: 1372.二叉树中的最长交错路径
 * @TitleSlug: longestZigzagPathInABinaryTree
 * @Author: Neo
 * @Date: 2023-11-13 12:47:18
 */
package leetcode.editor.cn;

public class 二叉树中的最长交错路径 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 二叉树中的最长交错路径().new Solution();
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
        int ans = 0;

        public int longestZigZag(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root, 0, true);
            dfs(root, 0, false);
            return ans;
        }

        private void dfs(TreeNode root, int len, boolean flg) {
            ans = Math.max(ans, len);
            if (!flg) {
                if (root.left != null) {
                    dfs(root.left, len + 1, true);
                }
                if (root.right != null) {
                    dfs(root.right, 1, false);
                }
            } else {
                if (root.left != null) {
                    dfs(root.left, 1, true);
                }
                if (root.right != null) {
                    dfs(root.right, len + 1, false);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       