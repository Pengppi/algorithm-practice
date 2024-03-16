/**
 * @Title: 117.填充每个节点的下一个右侧节点指针 II
 * @TitleSlug: populatingNextRightPointersInEachNodeIi
 * @Author: Neo
 * @Date: 2024-03-15 18:58:44
 */
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class 填充每个节点的下一个右侧节点指针IIpopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 填充每个节点的下一个右侧节点指针IIpopulatingNextRightPointersInEachNodeIi().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
    
    class Solution {
        public Node connect(Node root) {
            Deque<Node> queue = new LinkedList<>();
            if (root != null) {
                queue.offer(root);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node pre = null;
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (pre != null) {
                        pre.next = node;
                    }
                    pre = node;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        
        public Node() {
        }
        
        public Node(int _val) {
            val = _val;
        }
        
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
       