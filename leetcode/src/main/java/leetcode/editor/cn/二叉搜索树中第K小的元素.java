/**
 * @Title: 230.二叉搜索树中第K小的元素
 * @TitleSlug: kthSmallestElementInABst
 * @Author: Neo
 * @Date: 2024-01-24 17:54:16
 */
package leetcode.editor.cn;

public class 二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉搜索树中第K小的元素().new Solution();
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
        int cnt = 0;
        int ans = -1;
        
        public int kthSmallest(TreeNode root, int k) {
            dfs(root, k);
            return ans;
        }
        
        private void dfs(final TreeNode node, final int k) {
            if (node.left != null) {
                dfs(node.left, k);
            }
            cnt++;
            if (cnt == k) {
                ans = node.val;
                return;
            } else if (cnt > k) {
                return;
            }
            if (node.right != null) {
                dfs(node.right, k);
            }
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
        
       