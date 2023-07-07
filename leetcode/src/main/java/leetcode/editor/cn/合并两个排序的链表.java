/**
 * @Title: 剑指 Offer 25.合并两个排序的链表
 * @TitleSlug: heBingLiangGePaiXuDeLianBiaoLcof
 * @Author: Neo
 * @Date: 2023-05-20 18:19:50
 */
package leetcode.editor.cn;

import javax.swing.tree.TreeNode;

public class 合并两个排序的链表 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 合并两个排序的链表().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode cur = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            while (l1 != null) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
            }
            while (l2 != null) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
        
       