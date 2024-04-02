/**
 * @Title: 1379.找出克隆二叉树中的相同节点
 * @TitleSlug: findACorrespondingNodeOfABinaryTreeInACloneOfThatTree
 * @Author: Neo
 * @Date: 2024-04-03 00:38:01
 */
package leetcode.editor.cn;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 找出克隆二叉树中的相同节点findACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 找出克隆二叉树中的相同节点findACorrespondingNodeOfABinaryTreeInACloneOfThatTree().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
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
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            Deque<TreeNode> q1 = new ArrayDeque<>();
            Deque<TreeNode> q2 = new ArrayDeque<>();
            q1.offer(original);
            q2.offer(cloned);
            while (!q1.isEmpty()) {
                TreeNode node1 = q1.poll();
                TreeNode node2 = q2.poll();
                if (node1 == target) {
                    return node2;
                }
                if (node1.left != null) {
                    q1.offer(node1.left);
                    q2.offer(node2.left);
                }
                if (node1.right != null) {
                    q1.offer(node1.right);
                    q2.offer(node2.right);
                }
            }
            return null;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       