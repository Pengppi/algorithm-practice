/**
 * @Title: 剑指 Offer 52.两个链表的第一个公共节点
 * @TitleSlug: liangGeLianBiaoDeDiYiGeGongGongJieDianLcof
 * @Author: Neo
 * @Date: 2023-05-20 18:19:54
 */
package leetcode.editor.cn;

public class 两个链表的第一个公共节点 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 两个链表的第一个公共节点().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
    class Solution {
        ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       