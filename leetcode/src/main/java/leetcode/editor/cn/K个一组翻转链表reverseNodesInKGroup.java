/**
 * @Title: 25.K 个一组翻转链表
 * @TitleSlug: reverseNodesInKGroup
 * @Author: Neo
 * @Date: 2024-03-26 10:54:12
 */
package leetcode.editor.cn;

import entity.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class K个一组翻转链表reverseNodesInKGroup {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new K个一组翻转链表reverseNodesInKGroup().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            while (head != null) {
                ListNode tail = pre;
                for (int i = 0; i < k; i++) {
                    tail = tail.next;
                    if (tail == null) {
                        return dummy.next;
                    }
                }
                ListNode reverse = tail.next;
                ListNode cur = head;
                while (reverse != tail) {
                    ListNode next = cur.next;
                    cur.next = reverse;
                    reverse = cur;
                    cur = next;
                }
                pre.next = tail;
                pre = head;
                head = head.next;
            }
            return dummy.next;
        }
        
        private ListNode f1(ListNode head, int k) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            Deque<ListNode> stack = new ArrayDeque<>();
            ListNode pre = dummy;
            ListNode cur = head;
            while (cur != null) {
                for (int i = 0; i < k && cur != null; i++) {
                    stack.push(cur);
                    cur = cur.next;
                }
                if (stack.size() != k) {
                    break;
                }
                while (!stack.isEmpty()) {
                    pre.next = stack.pop();
                    pre = pre.next;
                }
                pre.next = cur;
            }
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       