/**
 * @Title: 114.二叉树展开为链表
 * @TitleSlug: flattenBinaryTreeToLinkedList
 * @Author: Neo
 * @Date: 2023-12-17 00:29:24
 */
package leetcode.editor.cn;

public class 二叉树展开为链表 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 二叉树展开为链表().new Solution();
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
        TreeNode last;

        public void flatten(TreeNode root) {
            preOrderSearch(root);
        }

        private void preOrderSearch(TreeNode node) {
            if (node == null) {
                return;
            }
            if (last != null) {
                last.right = node;
                last.left = null;
            }
            last = node;
            TreeNode left = node.left;
            TreeNode right = node.right;
            preOrderSearch(left);
            preOrderSearch(right);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
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
        
       