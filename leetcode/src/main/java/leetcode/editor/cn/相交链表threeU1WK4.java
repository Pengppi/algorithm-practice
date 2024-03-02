/**
 * @Title: LCR 023.相交链表
 * @TitleSlug: threeU1WK4
 * @Author: Neo
 * @Date: 2024-03-02 12:11:50
 */
package leetcode.editor.cn;

public class 相交链表threeU1WK4 {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new 相交链表threeU1WK4().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }
    
    // leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
       