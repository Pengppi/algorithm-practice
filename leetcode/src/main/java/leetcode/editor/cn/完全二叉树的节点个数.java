/**
 * @Title: 222.完全二叉树的节点个数
 * @TitleSlug: countCompleteTreeNodes
 * @Author: Neo
 * @Date: 2023-12-20 00:14:57
 */
package leetcode.editor.cn;

public class 完全二叉树的节点个数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 完全二叉树的节点个数().new Solution();
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
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = countLevels(root.left);
            int right = countLevels(root.right);
            if (left == right) {
                return countNodes(root.right) + (1 << left);
            } else {
                return countNodes(root.left) + (1 << right);
            }
        }

        private int countLevels(TreeNode node) {
            int lv = 0;
            while (node != null) {
                lv++;
                node = node.left;
            }
            return lv;
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
        
       