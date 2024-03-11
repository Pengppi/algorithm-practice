/**
 * @Title: LCR 043.完全二叉树插入器
 * @TitleSlug: NaqhDT
 * @Author: Neo
 * @Date: 2024-03-11 14:10:24
 */
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class 完全二叉树插入器NaqhDT {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 完全二叉树插入器NaqhDT().new Solution();
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
    class CBTInserter {
        
        Deque<TreeNode> queue;
        Deque<TreeNode> tmp;
        TreeNode root;
        
        public CBTInserter(TreeNode root) {
            queue = new LinkedList<>();
            tmp = new LinkedList<>();
            this.root = root;
            tmp.offer(root);
            int layer = 0;
            while (!tmp.isEmpty()) {
                int sz = tmp.size();
                if (sz != (1 << layer)) {
                    break;
                }
                queue.clear();
                queue.addAll(tmp);
                for (int i = sz; i > 0; i--) {
                    TreeNode node = tmp.poll();
                    if (node.left != null) {
                        tmp.offer(node.left);
                    }
                    if (node.right != null) {
                        tmp.offer(node.right);
                    }
                }
                layer++;
            }
        }
        
        public int insert(int v) {
            TreeNode child = new TreeNode(v);
            tmp.offer(child);
            TreeNode parent = queue.peek();
            while (parent.left != null && parent.right != null) {
                queue.poll();
                parent = queue.peek();
            }
            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
                queue.poll();
            }
            if (queue.isEmpty()) {
                queue.addAll(tmp);
                tmp.clear();
            }
            return parent.val;
        }
        
        public TreeNode get_root() {
            return root;
        }
    }
    
    /**
     * Your CBTInserter object will be instantiated and called as such:
     * CBTInserter obj = new CBTInserter(root);
     * int param_1 = obj.insert(v);
     * TreeNode param_2 = obj.get_root();
     */
// leetcode submit region end(Prohibit modification and deletion)
    private class TreeNode {
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
       