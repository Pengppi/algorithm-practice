/**
 * @Title: 剑指 Offer 07.重建二叉树
 * @TitleSlug: zhongJianErChaShuLcof
 * @Author: Neo
 * @Date: 2023-07-07 13:31:35
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class 重建二叉树 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 重建二叉树().new Solution();
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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            int len = 0;
            while (inorder[len] != preorder[0]) {
                len++;
            }
            TreeNode rt = new TreeNode(preorder[0]);
            int[] lp = Arrays.copyOfRange(preorder, 1, 1 + len);
            int[] li = Arrays.copyOfRange(inorder, 0, len);
            rt.left = buildTree(lp, li);

            int[] rp = Arrays.copyOfRange(preorder, 1 + len, preorder.length);
            int[] ri = Arrays.copyOfRange(inorder, len + 1, inorder.length);
            rt.right = buildTree(rp, ri);
            return rt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       