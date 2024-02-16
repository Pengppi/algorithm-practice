/**
 * @Title: 103.二叉树的锯齿形层序遍历
 * @TitleSlug: binaryTreeZigzagLevelOrderTraversal
 * @Author: Neo
 * @Date: 2024-02-16 18:21:11
 */
package leetcode.editor.cn;

import java.util.*;

public class 二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树的锯齿形层序遍历().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Deque<TreeNode> q = new LinkedList<>();
            q.add(root);
            int cur = 0;
            while (!q.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                for (int i = q.size(); i > 0; i--) {
                    TreeNode node = q.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                if ((cur++ & 1) == 1) {
                    Collections.reverse(list);
                }
                ans.add(list);
            }
            return ans;
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
        
       