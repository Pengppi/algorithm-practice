/**
 * @Title: 141.环形链表
 * @TitleSlug: linkedListCycle
 * @Author: Neo
 * @Date: 2024-02-09 19:43:00
 */
package leetcode.editor.cn;

public class 环形链表 {
    public static void main(String[] args) {
        // 测试代码
        // Solution solution = new 环形链表().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
        
       