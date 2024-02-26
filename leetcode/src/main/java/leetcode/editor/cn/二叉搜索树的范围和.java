/**
 * @Title: 938.二叉搜索树的范围和
 * @TitleSlug: rangeSumOfBst
 * @Author: Neo
 * @Date: 2024-02-26 23:20:49
 */
package leetcode.editor.cn;

public class 二叉搜索树的范围和 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉搜索树的范围和().new Solution();
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
        
        public int rangeSumBST(TreeNode root, int low, int high) {
            dfs(root, low, high);
            return ans;
        }
        
        private void dfs(final TreeNode node, final int low, final int high) {
            if (node == null) {
                return;
            }
            if (node.val < low) {
                dfs(node.right, low, high);
                return;
            }
            if (node.val > high) {
                dfs(node.left, low, high);
                return;
            }
            ans += node.val;
            dfs(node.left, low, high);
            dfs(node.right, low, high);
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
        
       