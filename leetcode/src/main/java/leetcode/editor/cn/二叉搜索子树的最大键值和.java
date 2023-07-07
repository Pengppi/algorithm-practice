/**
 * @Title: 1373.二叉搜索子树的最大键值和
 * @TitleSlug: maximumSumBstInBinaryTree
 * @Author: Neo
 * @Date: 2023-05-20 12:06:20
 */
package leetcode.editor.cn;

public class 二叉搜索子树的最大键值和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉搜索子树的最大键值和().new Solution();
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
        int ans = 0;

        public int maxSumBST(TreeNode root) {
            f(root);
            return ans;
        }

        private int[] f(TreeNode root) {
            if (root == null) {
                return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
            }
            int[] l = f(root.left);
            int[] r = f(root.right);
            int cur = root.val;
            if (cur <= l[1] || cur >= r[0]) {
                return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
            }
            int sum = cur + l[2] + r[2];
            ans = Math.max(ans, sum);
            return new int[]{Math.min(l[0], cur), Math.max(r[1], cur), sum};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       