/**
 * @Title: 637.二叉树的层平均值
 * @TitleSlug: averageOfLevelsInBinaryTree
 * @Author: Neo
 * @Date: 2023-12-21 00:41:44
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的层平均值 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 二叉树的层平均值().new Solution();
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
        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            List<Double> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                double sz = queue.size();
                long sum = 0;
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode p = queue.poll();
                    sum += p.val;
                    if (p.left != null) {
                        queue.offer(p.left);
                    }
                    if (p.right != null) {
                        queue.offer(p.right);
                    }
                }
                ans.add(sum / sz);
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
        
       