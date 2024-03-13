/**
 * @Title: 103.二叉树的锯齿形层序遍历
 * @TitleSlug: binaryTreeZigzagLevelOrderTraversal
 * @Author: Neo
 * @Date: 2024-03-13 09:34:09
 */
package leetcode.editor.cn;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的锯齿形层序遍历binaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 二叉树的锯齿形层序遍历binaryTreeZigzagLevelOrderTraversal().new Solution();
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
            List<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean isOrderLeft = true;
            while (!queue.isEmpty()) {
                List<Integer> levelList = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove(0);
                    if (node == null) {
                        continue;
                    }
                    if (isOrderLeft) {
                        levelList.add(node.val);
                    } else {
                        levelList.add(0, node.val);
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }
                if (!levelList.isEmpty()) {
                    ans.add(levelList);
                }
                isOrderLeft = !isOrderLeft;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       