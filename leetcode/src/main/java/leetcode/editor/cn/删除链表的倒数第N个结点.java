/**
 * @Title: 19.删除链表的倒数第 N 个结点
 * @TitleSlug: removeNthNodeFromEndOfList
 * @Author: Neo
 * @Date: 2024-01-12 09:23:13
 */
package leetcode.editor.cn;

public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 删除链表的倒数第N个结点().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int cnt = 0;
            ListNode dummy = new ListNode(-1, head);
            ListNode fast = head, solw = dummy;
            while (fast.next != null) {
                cnt++;
                fast = fast.next;
                if (cnt >= n) {
                    solw = solw.next;
                }
            }
            if (solw.next != null) {
                solw.next = solw.next.next;
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
        
       