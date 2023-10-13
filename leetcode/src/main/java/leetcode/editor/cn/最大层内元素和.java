/**
 * @Title: 1161.最大层内元素和
 * @TitleSlug: maximumLevelSumOfABinaryTree
 * @Author: Neo
 * @Date: 2023-10-14 00:32:04
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 最大层内元素和 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 最大层内元素和().new Solution();
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
        public int maxLevelSum(TreeNode root) {
            int ans = 1, mx = root.val, layer = 1;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int sum = 0;
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode p = queue.pop();
                    sum += p.val;
                    if (p.left != null) {
                        queue.offer(p.left);
                    }
                    if (p.right != null) {
                        queue.offer(p.right);
                    }
                }
                if (sum > mx) {
                    mx = sum;
                    ans = layer;
                }
                layer++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       