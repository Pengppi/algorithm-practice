/**
 * @Title: 2.两数相加
 * @TitleSlug: AddTwoNumbers
 * @Author: Neo
 * @Date: 2022-10-21 00:49:26
 */
package leetcode.editor.cn;

public class 两数相加 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 两数相加().new Solution();
    }

//力扣代码
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode cur = head;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                carry = sum / 10;
                sum = sum % 10;
                ListNode next = new ListNode(sum);
                cur.next = next;
                cur = next;
            }
            if (carry != 0) {
                cur.next = new ListNode(carry);
            }
            return head.next;
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
