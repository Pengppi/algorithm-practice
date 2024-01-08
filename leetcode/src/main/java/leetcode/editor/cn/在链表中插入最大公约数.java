/**
 * @Title: 2807.在链表中插入最大公约数
 * @TitleSlug: insertGreatestCommonDivisorsInLinkedList
 * @Author: Neo
 * @Date: 2024-01-07 15:51:14
 */
package leetcode.editor.cn;

public class 在链表中插入最大公约数 {
    public static void main(String[] args) {
        //测试代码
        //Solution solution = new 在链表中插入最大公约数().new Solution();
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
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            while (cur.next != null) {
                ListNode next = cur.next;
                int val = gcd(cur.val, next.val);
                ListNode node = new ListNode(val);
                cur.next = node;
                node.next = next;
                cur = next;
            }
            return head;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
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
        
       