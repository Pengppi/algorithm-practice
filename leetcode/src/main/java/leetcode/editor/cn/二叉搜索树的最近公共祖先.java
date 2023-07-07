/**
 * @Title: 剑指 Offer 68 - I.二叉搜索树的最近公共祖先
 * @TitleSlug: erChaSouSuoShuDeZuiJinGongGongZuXianLcof
 * @Author: Neo
 * @Date: 2023-05-18 14:10:07
 */
package leetcode.editor.cn;

public class 二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉搜索树的最近公共祖先().new Solution();
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       