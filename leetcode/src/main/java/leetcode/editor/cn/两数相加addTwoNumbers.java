/**
 * @Title: 2.两数相加
 * @TitleSlug: addTwoNumbers
 * @Author: Neo
 * @Date: 2024-04-29 15:55:37
 */
package leetcode.editor.cn;

import entity.ListNode;

public class 两数相加addTwoNumbers {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 两数相加addTwoNumbers().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (l1 != null || l2 != null || carry != 0) {
                if (l1 != null) {
                    carry += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    carry += l2.val;
                    l2 = l2.next;
                }
                cur.next = new ListNode(carry % 10);
                cur = cur.next;
                carry /= 10;
            }
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
       