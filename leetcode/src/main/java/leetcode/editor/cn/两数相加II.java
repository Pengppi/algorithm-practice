/**
 * @Title: 445.两数相加 II
 * @TitleSlug: addTwoNumbersIi
 * @Author: Neo
 * @Date: 2023-07-10 18:56:24
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class 两数相加II {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 两数相加II().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<ListNode> d1 = new ArrayDeque<>();
            Deque<ListNode> d2 = new ArrayDeque<>();
            while (l1 != null) {
                d1.addLast(l1);
                l1 = l1.next;
            }
            while (l2 != null) {
                d2.addLast(l2);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode next = null;
            while (carry != 0 || !d1.isEmpty() || !d2.isEmpty()) {
                int sum = carry;
                if (!d1.isEmpty()) {
                    sum += d1.pollLast().val;
                }
                if (!d2.isEmpty()) {
                    sum += d2.pollLast().val;
                }
                ListNode cur = new ListNode(sum % 10, next);
                next = cur;
                carry = sum / 10;
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       