/**
 * @Title: 117.填充每个节点的下一个右侧节点指针 II
 * @TitleSlug: populatingNextRightPointersInEachNodeIi
 * @Author: Neo
 * @Date: 2023-11-03 14:00:53
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 填充每个节点的下一个右侧节点指针II {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 填充每个节点的下一个右侧节点指针II().new Solution();
    }

    class Node {
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

    //leetcode submit region begin(Prohibit modification and deletion)
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
            if (root == null) {
                return root;
            }
            Deque<Node> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                for (int i = q.size(); i > 0; i--) {
                    Node p = q.poll();
                    if (p.left != null) {
                        q.offer(p.left);
                    }
                    if (p.right != null) {
                        q.offer(p.right);
                    }
                    if (i > 1) {
                        p.next = q.peek();
                    }
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       