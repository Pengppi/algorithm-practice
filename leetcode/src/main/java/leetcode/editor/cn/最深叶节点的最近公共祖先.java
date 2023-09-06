/**
 * @Title: 1123.最深叶节点的最近公共祖先
 * @TitleSlug: lowestCommonAncestorOfDeepestLeaves
 * @Author: Neo
 * @Date: 2023-09-06 23:32:50
 */
package leetcode.editor.cn;

public class 最深叶节点的最近公共祖先 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最深叶节点的最近公共祖先().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
        private TreeNode ans;
        private int maxDepth = -1;

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            dfs(root, 0);
            return ans;
        }

        private int dfs(TreeNode node, int depth) {
            if (node == null) {
                maxDepth = Math.max(maxDepth, depth);
                return depth;
            }
            int leftDep = dfs(node.left, depth + 1);
            int rightDep = dfs(node.right, depth + 1);
            if (leftDep == rightDep && leftDep == maxDepth) {
                ans = node;
            }
            return Math.max(leftDep, rightDep);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       