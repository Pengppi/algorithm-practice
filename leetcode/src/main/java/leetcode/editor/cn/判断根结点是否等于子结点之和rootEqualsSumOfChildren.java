/**
 * @Title: 2236.判断根结点是否等于子结点之和
 * @TitleSlug: rootEqualsSumOfChildren
 * @Author: Neo
 * @Date: 2024-02-28 21:32:45
 */
package leetcode.editor.cn;

public class 判断根结点是否等于子结点之和rootEqualsSumOfChildren {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 判断根结点是否等于子结点之和rootEqualsSumOfChildren().new Solution();
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
        public boolean checkTree(TreeNode root) {
            return root.val == root.left.val + root.right.val;
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
       