/**
 * @Title: LCR 026.重排链表
 * @TitleSlug: LGjMqU
 * @Author: Neo
 * @Date: 2024-03-17 16:19:16
 */
package leetcode.editor.cn;

import entity.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 重排链表LGjMqU {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 重排链表LGjMqU().new Solution();
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
        public void reorderList(ListNode head) {
            if (head.next == null || head.next.next == null) {
                return;
            }
            Deque<ListNode> stack = new ArrayDeque<>();
            ListNode cur = head;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            int n = (stack.size() - 1) / 2;
            cur = head;
            while (n-- > 0) {
                ListNode tail = stack.pop();
                ListNode next = cur.next;
                cur.next = tail;
                tail.next = next;
                cur = next;
                stack.peek().next = null;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       