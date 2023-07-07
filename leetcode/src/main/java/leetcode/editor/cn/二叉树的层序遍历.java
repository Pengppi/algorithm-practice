/**
 * @Title: 102.二叉树的层序遍历
 * @TitleSlug: BinaryTreeLevelOrderTraversal
 * @Author: Neo
 * @Date: 2022-10-29 13:29:51
 */
package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的层序遍历 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉树的层序遍历().new Solution();
    }

    //力扣代码
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Deque<TreeNode> d = new ArrayDeque<>();
            if (root != null) {
                d.offer(root);
            }
            while (!d.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                for (int i = d.size(); i > 0; i--) {
                    TreeNode t = d.poll();
                    list.add(t.val);
                    if (t.left != null) {
                        d.offer(t.left);
                    }
                    if (t.right != null) {
                        d.offer(t.right);
                    }
                }
                ans.add(list);
            }
            return ans;
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
