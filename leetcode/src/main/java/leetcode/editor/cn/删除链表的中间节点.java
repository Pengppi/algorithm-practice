/**
 * @Title: 2095.删除链表的中间节点
 * @TitleSlug: deleteTheMiddleNodeOfALinkedList
 * @Author: Neo
 * @Date: 2023-10-12 10:22:17
 */
package leetcode.editor.cn;

public class 删除链表的中间节点 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 删除链表的中间节点().new Solution();
    }

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
        public ListNode deleteMiddle(ListNode head) {
            if (head.next == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            ListNode prev = null;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }
            prev.next=slow.next;
            return head;
        }

        private ListNode getListNode(ListNode head) {
            int n = 0;
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                n++;
            }
            if (n == 1) {
                return null;
            }
            cur = head;
            ListNode prev = null;
            int k = n / 2;
            for (int i = 0; i < k; i++) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       