/**
 * @Title: LCR 045.找树左下角的值
 * @TitleSlug: LwUNpT
 * @Author: Neo
 * @Date: 2024-02-25 16:04:13
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 找树左下角的值 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 找树左下角的值().new Solution();
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
        public int findBottomLeftValue(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int ans = root.val;
            while (!queue.isEmpty()) {
                ans = queue.peek().val;
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
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
        
       