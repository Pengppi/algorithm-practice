/**
 * @Title: 144.二叉树的前序遍历
 * @TitleSlug: binaryTreePreorderTraversal
 * @Author: Neo
 * @Date: 2024-02-11 22:46:22
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的前序遍历 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树的前序遍历().new Solution();
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
        private List<Integer> ans;
        
        public List<Integer> preorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            dfs(root);
            return ans;
        }
        
        private void dfs(final TreeNode node) {
            if (node == null) {
                return;
            }
            ans.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
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
}
        
       