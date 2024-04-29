/**
 * @Title: 230.二叉搜索树中第K小的元素
 * @TitleSlug: kthSmallestElementInABst
 * @Author: Neo
 * @Date: 2024-04-29 15:59:17
 */
package leetcode.editor.cn;

import entity.TreeNode;

public class 二叉搜索树中第K小的元素kthSmallestElementInABst {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉搜索树中第K小的元素kthSmallestElementInABst().new Solution();
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
        private int cnt = 0, ans = -1;
        
        public int kthSmallest(TreeNode root, int k) {
            dfs(root, k);
            return ans;
        }
        
        private void dfs(TreeNode node, int k) {
            if (node == null) {
                return;
            }
            dfs(node.left, k);
            cnt++;
            if (cnt < k) {
                dfs(node.right, k);
            } else if (cnt == k) {
                ans = node.val;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       