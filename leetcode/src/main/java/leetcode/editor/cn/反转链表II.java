/**
 * @Title: 92.反转链表 II
 * @TitleSlug: reverseLinkedListIi
 * @Author: Neo
 * @Date: 2023-12-18 00:52:04
 */
package leetcode.editor.cn;

public class 反转链表II {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 反转链表II().new Solution();
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode cur = head;
            ListNode dummy = new ListNode(-1, head);
            ListNode p = dummy;
            ListNode lp = null;
            for (int i = 1; i <= right; i++) {
                if (i <= left) {
                    if (i == left) {
                        lp = p;
                    }
                    p = cur;
                    cur = cur.next;
                }
                if (i > left) {
                    ListNode next = cur.next;
                    cur.next = p;
                    p = cur;
                    cur = next;
                }
                if (i == right) {
                    ListNode l = lp.next;
                    l.next = cur;
                    lp.next = p;
                }
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
        
       