/**
 * @Title: 450.删除二叉搜索树中的节点
 * @TitleSlug: deleteNodeInABst
 * @Author: Neo
 * @Date: 2023-11-07 13:44:51
 */
package leetcode.editor.cn;

public class 删除二叉搜索树中的节点 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 删除二叉搜索树中的节点().new Solution();
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else {
                root = delete(root);
            }
            return root;
        }


        private TreeNode delete(TreeNode root) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (right == null) {
                return left;
            }
            TreeNode cur = right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = left;
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       