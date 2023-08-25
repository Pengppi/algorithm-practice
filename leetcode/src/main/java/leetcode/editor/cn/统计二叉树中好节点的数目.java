/**
 * @Title: 1448.统计二叉树中好节点的数目
 * @TitleSlug: countGoodNodesInBinaryTree
 * @Author: Neo
 * @Date: 2023-08-25 21:03:46
 */
package leetcode.editor.cn;

public class 统计二叉树中好节点的数目 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 统计二叉树中好节点的数目().new Solution();
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

        public int goodNodes(TreeNode root) {

            dfs(root, Integer.MIN_VALUE);
            return ans;
        }

        private void dfs(TreeNode root, int maxValue) {
            if (root == null) {
                return;
            }
            if (maxValue <= root.val) {
                ans++;
                maxValue = root.val;
            }
            dfs(root.left, maxValue);
            dfs(root.right, maxValue);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       