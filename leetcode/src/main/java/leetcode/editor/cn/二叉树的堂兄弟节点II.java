/**
 * @Title: 2641.二叉树的堂兄弟节点 II
 * @TitleSlug: cousinsInBinaryTreeIi
 * @Author: Neo
 * @Date: 2024-02-07 22:48:36
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的堂兄弟节点II {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树的堂兄弟节点II().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
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
        List<Integer> sums = new ArrayList<>();
        
        public TreeNode replaceValueInTree(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int sum = 0;
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                sums.add(sum);
            }
            root.val = 0;
            dfs(root, 1);
            return root;
        }
        
        private void dfs(final TreeNode root, final int h) {
            if (h == sums.size()) {
                return;
            }
            int curSum = sums.get(h);
            if (root.left != null && root.right != null) {
                curSum -= root.left.val;
                curSum -= root.right.val;
                root.left.val = curSum;
                root.right.val = curSum;
                dfs(root.left, h + 1);
                dfs(root.right, h + 1);
            } else if (root.left != null) {
                curSum -= root.left.val;
                root.left.val = curSum;
                dfs(root.left, h + 1);
            } else if (root.right != null) {
                curSum -= root.right.val;
                root.right.val = curSum;
                dfs(root.right, h + 1);
            }
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
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
        
       