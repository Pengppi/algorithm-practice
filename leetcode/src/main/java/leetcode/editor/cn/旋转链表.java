/**
 * @Title: 61.旋转链表
 * @TitleSlug: rotateList
 * @Author: Neo
 * @Date: 2024-01-23 15:16:39
 */
package leetcode.editor.cn;

public class 旋转链表 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 旋转链表().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) {
                return head;
            }
            ListNode dummy = new ListNode(-1, head);
            ListNode fast = head;
            int n = 0;
            while (fast != null) {
                fast = fast.next;
                n++;
            }
            k = k % n;
            fast = head;
            ListNode slow = head;
            int cnt = 0;
            while (fast.next != null) {
                fast = fast.next;
                cnt++;
                if (cnt > k) {
                    slow = slow.next;
                }
            }
            fast.next = dummy.next;
            dummy.next = slow.next;
            slow.next = null;
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
        
       