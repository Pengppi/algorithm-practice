/**
 * @Title: 145.二叉树的后序遍历
 * @TitleSlug: binaryTreePostorderTraversal
 * @Author: Neo
 * @Date: 2024-02-12 12:55:56
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的后序遍历 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树的后序遍历().new Solution();
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
        List<Integer> ans;
        
        public List<Integer> postorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            dfs(root);
            return ans;
        }
        
        private void dfs(final TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            dfs(node.right);
            ans.add(node.val);
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
        
       