/**
 * @Title: 2415.反转二叉树的奇数层
 * @TitleSlug: reverseOddLevelsOfBinaryTree
 * @Author: Neo
 * @Date: 2023-12-15 21:39:50
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 反转二叉树的奇数层 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 反转二叉树的奇数层().new Solution();
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
        public TreeNode reverseOddLevels(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int layer = 0;
            while (!queue.isEmpty()) {
                List<TreeNode> list = new ArrayList<>(queue.size());
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if ((layer & 1) == 1) {
                        list.add(node);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                if ((layer & 1) == 1) {
                    int l = 0, r = list.size() - 1;
                    while (l < r) {
                        TreeNode left = list.get(l++);
                        TreeNode right = list.get(r--);
                        int tmp = left.val;
                        left.val = right.val;
                        right.val = tmp;
                    }
                }
                layer++;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       