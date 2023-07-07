/**
 * @Title: 剑指 Offer 55 - I.二叉树的深度
 * @TitleSlug: erChaShuDeShenDuLcof
 * @Author: Neo
 * @Date: 2023-04-28 13:16:29
 */
package leetcode.editor.cn;

public class 二叉树的深度 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉树的深度().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       