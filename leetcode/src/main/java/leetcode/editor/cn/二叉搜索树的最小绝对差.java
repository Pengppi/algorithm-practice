/**
 * @Title: 530.二叉搜索树的最小绝对差
 * @TitleSlug: minimumAbsoluteDifferenceInBst
 * @Author: Neo
 * @Date: 2023-12-13 13:21:40
 */
package leetcode.editor.cn;

public class 二叉搜索树的最小绝对差 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 二叉搜索树的最小绝对差().new Solution();
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

        int ans = Integer.MAX_VALUE, mx = -100000;

        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            ans = Math.min(ans, node.val - mx);
            mx = node.val;
            dfs(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       