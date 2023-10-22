/**
 * @Title: 700.二叉搜索树中的搜索
 * @TitleSlug: searchInABinarySearchTree
 * @Author: Neo
 * @Date: 2023-10-23 00:28:59
 */
package leetcode.editor.cn;

public class 二叉搜索树中的搜索 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉搜索树中的搜索().new Solution();
    }

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
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }
            return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       