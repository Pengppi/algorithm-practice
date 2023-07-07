/**
 * @Title: 剑指 Offer 35.复杂链表的复制
 * @TitleSlug: fuZaLianBiaoDeFuZhiLcof
 * @Author: Neo
 * @Date: 2023-05-29 14:53:29
 */
package leetcode.editor.cn;

import java.util.HashMap;

public class 复杂链表的复制 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 复杂链表的复制().new Solution();
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
            if (head == null) {
                return null;
            }
            if (!map.containsKey(head)) {
                Node t = new Node(head.val);
                map.put(head, t);
                t.next = copyRandomList(head.next);
                t.random = copyRandomList(head.random);
            }
            return map.get(head);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       