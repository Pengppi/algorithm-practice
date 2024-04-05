/**
 * @Title: 1026.节点与其祖先之间的最大差值
 * @TitleSlug: maximumDifferenceBetweenNodeAndAncestor
 * @Author: Neo
 * @Date: 2024-04-05 01:43:42
 */
package leetcode.editor.cn;

import entity.TreeNode;

public class 节点与其祖先之间的最大差值maximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 节点与其祖先之间的最大差值maximumDifferenceBetweenNodeAndAncestor().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
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
        private int ans = 0;
        
        public int maxAncestorDiff(TreeNode root) {
            dfs(root);
            return ans;
        }
        
        private int[] dfs(TreeNode node) {
            int mx = node.val, mn = node.val;
            if (node.left != null) {
                int[] res = dfs(node.left);
                mn = Math.min(mn, res[0]);
                mx = Math.max(mx, res[1]);
            }
            if (node.right != null) {
                int[] res = dfs(node.right);
                mn = Math.min(mn, res[0]);
                mx = Math.max(mx, res[1]);
            }
            ans = Math.max(ans, Math.max(Math.abs(node.val - mn), Math.abs(node.val - mx)));
            return new int[]{mn, mx};
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       