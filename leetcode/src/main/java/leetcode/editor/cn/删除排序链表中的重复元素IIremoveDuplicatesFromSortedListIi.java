/**
 * @Title: 82.删除排序链表中的重复元素 II
 * @TitleSlug: removeDuplicatesFromSortedListIi
 * @Author: Neo
 * @Date: 2024-03-03 11:00:26
 */
package leetcode.editor.cn;

public class 删除排序链表中的重复元素IIremoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 删除排序链表中的重复元素IIremoveDuplicatesFromSortedListIi().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode cur = dummy;
            while (cur != null) {
                ListNode next = cur.next;
                while (next != null && next.next != null && next.val == next.next.val) {
                    next = next.next;
                }
                if (cur.next != next) {
                    cur.next = next.next;
                } else {
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
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
       