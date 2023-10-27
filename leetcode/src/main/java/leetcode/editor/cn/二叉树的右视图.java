/**
 * @Title: 199.二叉树的右视图
 * @TitleSlug: binaryTreeRightSideView
 * @Author: Neo
 * @Date: 2023-10-27 15:07:39
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的右视图 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 二叉树的右视图().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode t = queue.poll();
                    if (i == 1) {
                        ans.add(t.val);
                    }
                    if (t.left != null) {
                        queue.offer(t.left);
                    }
                    if (t.right != null) {
                        queue.offer(t.right);
                    }
                }
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       