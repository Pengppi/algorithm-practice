/**
 * @Title: 剑指 Offer 32 - I.从上到下打印二叉树
 * @TitleSlug: congShangDaoXiaDaYinErChaShuLcof
 * @Author: Neo
 * @Date: 2023-04-29 14:30:05
 */
package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class 从上到下打印二叉树 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 从上到下打印二叉树().new Solution();
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
        public int[] levelOrder(TreeNode root) {
            if(root==null)
            {
                return new int[0];
            }
            Deque<TreeNode> d = new ArrayDeque<>();
            d.addLast(root);
            List<Integer> list = new ArrayList<>();
            while (!d.isEmpty()) {
                for (int i = d.size(); i > 0; i--) {
                    TreeNode node = d.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        d.addLast(node.left);
                    }
                    if (node.right != null) {
                        d.addLast(node.right);
                    }
                }
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       