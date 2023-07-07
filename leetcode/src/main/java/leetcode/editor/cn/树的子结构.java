/**
 * @Title: 剑指 Offer 26.树的子结构
 * @TitleSlug: shuDeZiJieGouLcof
 * @Author: Neo
 * @Date: 2023-04-29 13:58:51
 */
package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

public class 树的子结构 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 树的子结构().new Solution();
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


        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return (A != null && B != null) && (recur(A, B)|| isSubStructure(A.left, B) || isSubStructure(A.right, B));

        }

        public boolean recur(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            }
            if (A == null || A.val != B.val) {
                return false;
            }
            return recur(A.left, B.left) && recur(A.right, B.right);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       