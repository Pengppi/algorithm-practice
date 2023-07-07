/**
 * @Title: 剑指 Offer 32 - II.从上到下打印二叉树 II
 * @TitleSlug: congShangDaoXiaDaYinErChaShuIiLcof
 * @Author: Neo
 * @Date: 2023-06-02 15:38:35
 */
package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 从上到下打印二叉树II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 从上到下打印二叉树II().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Deque<TreeNode> d = new ArrayDeque<>();
            d.addLast(root);
            while (!d.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                for (int i = d.size(); i > 0; i--) {
                    TreeNode t = d.pollFirst();
                    list.add(t.val);
                    if (t.left != null) {
                        d.addLast(t.left);
                    }
                    if (t.right != null) {
                        d.addLast(t.right);
                    }
                }
                ans.add(list);
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       