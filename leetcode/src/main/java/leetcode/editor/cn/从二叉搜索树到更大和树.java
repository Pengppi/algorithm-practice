/**
 * @Title: 1038.从二叉搜索树到更大和树
 * @TitleSlug: binarySearchTreeToGreaterSumTree
 * @Author: Neo
 * @Date: 2023-12-04 13:28:13
 */
package leetcode.editor.cn;

public class 从二叉搜索树到更大和树 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 从二叉搜索树到更大和树().new Solution();
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
        private int mx = 0;

        public TreeNode bstToGst(TreeNode root) {
            dfs(root);
            return root;
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.right);
            mx += node.val;
            node.val = mx;
            dfs(node.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       