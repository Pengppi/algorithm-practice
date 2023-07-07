/**
 * @Title: 1171.从链表中删去总和值为零的连续节点
 * @TitleSlug: removeZeroSumConsecutiveNodesFromLinkedList
 * @Author: Neo
 * @Date: 2023-06-11 15:00:57
 */
package leetcode.editor.cn;

public class 从链表中删去总和值为零的连续节点 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 从链表中删去总和值为零的连续节点().new Solution();
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
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur != null) {
                ListNode p = cur.next;
                int sum = 0;
                while (p != null) {
                    sum += p.val;
                    if (sum == 0) {
                        cur.next = p.next;
                    }
                    p = p.next;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       