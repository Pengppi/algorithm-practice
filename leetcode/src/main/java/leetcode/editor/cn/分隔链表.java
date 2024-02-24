/**
 * @Title: 86.分隔链表
 * @TitleSlug: partitionList
 * @Author: Neo
 * @Date: 2024-02-24 10:46:32
 */
package leetcode.editor.cn;

public class 分隔链表 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 分隔链表().new Solution();
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
        public ListNode partition(ListNode head, int x) {
            ListNode dummy = new ListNode(-1, head);
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < x) {
                prev = prev.next;
            }
            ListNode cur = prev.next;
            while (cur != null) {
                while (cur.next != null && cur.next.val < x) {
                    ListNode next1 = prev.next;
                    ListNode next2 = cur.next.next;
                    prev.next = cur.next;
                    prev.next.next = next1;
                    prev = prev.next;
                    cur.next = next2;
                }
                cur = cur.next;
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
        
       