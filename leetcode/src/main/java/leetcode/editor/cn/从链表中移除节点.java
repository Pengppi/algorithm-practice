/**
 * @Title: 2487.从链表中移除节点
 * @TitleSlug: removeNodesFromLinkedList
 * @Author: Neo
 * @Date: 2024-01-03 08:37:24
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 从链表中移除节点 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 从链表中移除节点().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNodes(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            Deque<ListNode> st = new ArrayDeque<>();
            st.push(dummy);
            ListNode cur = head;
            while (cur != null) {
                while (st.size() > 1 && st.peek().val < cur.val) {
                    st.pop();
                }
                st.peek().next = cur;
                st.push(cur);
                cur = cur.next;
            }
            return dummy.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
        
       