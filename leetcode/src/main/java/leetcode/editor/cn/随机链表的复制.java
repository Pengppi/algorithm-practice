/**
 * @Title: 138.随机链表的复制
 * @TitleSlug: copyListWithRandomPointer
 * @Author: Neo
 * @Date: 2023-12-13 12:49:02
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 随机链表的复制 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 随机链表的复制().new Solution();
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        Map<Node, Node> map = new HashMap<>();

        public Node copyRandomList(Node head) {
            return build(head);
        }

        private Node build(Node node) {
            if (node == null) {
                return null;
            }
            if (map.containsKey(node)) {
                return map.get(node);
            }
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            newNode.next = build(node.next);
            newNode.random = build(node.random);
            return newNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       