/**
 * @Title: 872.叶子相似的树
 * @TitleSlug: leafSimilarTrees
 * @Author: Neo
 * @Date: 2023-11-01 16:27:25
 */
package leetcode.editor.cn;

public class 叶子相似的树 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 叶子相似的树().new Solution();
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            dfs(root1, sb1);
            dfs(root2, sb2);
            return sb1.toString().equals(sb2.toString());
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                sb.append(root.val).append("-");
            } else {
                dfs(root.left, sb);
                dfs(root.right, sb);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       