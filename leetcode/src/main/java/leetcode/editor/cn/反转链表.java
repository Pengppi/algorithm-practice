/**
 * @Title: 剑指 Offer 24.反转链表
 * @TitleSlug: fanZhuanLianBiaoLcof
 * @Author: Neo
 * @Date: 2023-05-13 23:17:07
 */
package leetcode.editor.cn;

public class 反转链表 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new 反转链表().new Solution();
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
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode pre = head;
            ListNode cur = head.next;
            head.next = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
        
       