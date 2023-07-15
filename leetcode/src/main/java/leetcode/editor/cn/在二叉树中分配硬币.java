/**
 * @Title: 979.在二叉树中分配硬币
 * @TitleSlug: distributeCoinsInBinaryTree
 * @Author: Neo
 * @Date: 2023-07-15 20:09:05
 */
package leetcode.editor.cn;

public class 在二叉树中分配硬币 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 在二叉树中分配硬币().new Solution();
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

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int l = dfs(node.left);
            int r = dfs(node.right);
            int s = node.val - l - r;
            ans += Math.abs(l) + Math.abs(r);
            return 1 - s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       