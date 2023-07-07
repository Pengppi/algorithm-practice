/**
 * @Title: 剑指 Offer 27.二叉树的镜像
 * @TitleSlug: erChaShuDeJingXiangLcof
 * @Author: Neo
 * @Date: 2023-05-31 15:04:00
 */
package leetcode.editor.cn;

public class 二叉树的镜像 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉树的镜像().new Solution();
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
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode tmp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       