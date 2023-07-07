/**
 * @Title: 1080.根到叶路径上的不足节点
 * @TitleSlug: insufficientNodesInRootToLeafPaths
 * @Author: Neo
 * @Date: 2023-05-22 21:16:00
 */
package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

public class 根到叶路径上的不足节点 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 根到叶路径上的不足节点().new Solution();
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
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            int ans = dfs(root, limit, 0);
            return ans < limit ? null : root;
        }

        private int dfs(TreeNode root, int limit, int sum) {
            if (root == null) {
                return sum;
            }
            sum += root.val;
            int res = sum;
            if (root.left != null && root.right != null) {
                int l = dfs(root.left, limit, sum);
                if (l < limit) {
                    root.left = null;
                }
                int r = dfs(root.right, limit, sum);
                if (r < limit) {
                    root.right = null;
                }
                res = Math.max(l, r);
            } else if (root.left != null) {
                int l = dfs(root.left, limit, sum);
                if (l < limit) {
                    root.left = null;
                }
                res = l;
            } else if (root.right != null) {
                int r = dfs(root.right, limit, sum);
                if (r < limit) {
                    root.right = null;
                }
                res = r;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       